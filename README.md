
# Java Spring Boot Quick Start
Using OpenAPI Generator Maven Plugin, H2 Database

## Maven Commands
- `mvn clean`
- `mvn install`
    - `mvn clean install`
- `mvn spring-boot:run`
- `mvn clean install -DskipTests`

## Step 1: Write YAML
- [Swagger Editor](https://editor.swagger.io/)
### Tips:
- Use `nameDto` to name components.
- IDs should have `"readOnly: true"` property.
- If a component has required fields, use `"required"`.
- To show only date, use `"date"` and not `"date-time"`.
- Nullables generate `<JsonNullable>`, which are difficult to handle (simply don't use nullable but use required).

## Step 2: Start Spring Boot Project
- [Spring Initializer](https://start.spring.io/)
    - Project: Maven
    - Language: Java
    - Spring Boot: 3.3.4
    - Project Metadata:
        - Packaging: Jar
        - Java: 21

## Step 3: Edit `pom.xml`
- [OpenAPI Generator Maven Plugin Docs](https://openapi-generator.tech/docs/plugins)
### Add This Plugin:
```xml
<plugin>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-generator-maven-plugin</artifactId>
    <version>7.9.0</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <inputSpec>${project.basedir}/src/main/resources/openapi.yaml</inputSpec>
                <generatorName>spring</generatorName>
                <apiPackage>it.apuliadigital.album.api</apiPackage>
                <modelPackage>it.apuliadigital.album.model</modelPackage>
                <supportingFilesToGenerate>ApiUtil.java</supportingFilesToGenerate>
                <configOptions>
                    <useSpringBoot3>true</useSpringBoot3>
                    <delegatePattern>false</delegatePattern>
                    <interfaceOnly>true</interfaceOnly>
                </configOptions>
            </configuration>
        </execution>
    </executions>
</plugin>
```
### Add These Dependencies:
- [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)
- [Jackson Databind Nullable](https://mvnrepository.com/artifact/org.openapitools/jackson-databind-nullable)
- [Springdoc OpenAPI Starter](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui)

### Access Swagger UI
- `http://localhost:8080/swagger-ui/index.html`

## Step 4: Create Project Structure
In the same folder as `Application.java`:
- `controller`
- `entity`
- `service`
    - `impl`
- `repository`
- `mapper`

## Step 5: Set H2 Database
### Dependencies:
- [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
- [H2 Database](https://mvnrepository.com/artifact/com.h2database/h2)
    - Remove `<scope>test</scope>` to avoid exceptions.

### Properties:
#### DB in Memory:
```
spring.datasource.url=jdbc:h2:mem:testdb
```
#### DB in Local:
```
spring.datasource.url=jdbc:h2:file:./data/demo
```
#### Set Driver:
```
spring.datasource.driverClassName=org.h2.Driver
```
#### Set Credentials:
```
spring.datasource.username=sa
spring.datasource.password=password
```
#### Set Dialect:
```
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```
#### Set Console:
```
spring.h2.console.enabled=true
```
#### Create or Update Database:
```
spring.jpa.hibernate.ddl-auto=create
spring.jpa.hibernate.ddl-auto=validate
```
#### Show SQL in Console:
```
spring.jpa.show-sql=true
```

### Access H2 Console
- `http://localhost:8080/h2-console`

### Change Server Port
```
server.port=80
```
(Replace `80` with the desired port)

## Step 6: Use MapStruct
### Dependencies:
- [MapStruct](https://mvnrepository.com/artifact/org.mapstruct/mapstruct)

### Plugin:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.11.0</version>
    <configuration>
        <annotationProcessorPaths>
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>1.6.2</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```

### Mapper Interface Example:
```java
@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {
    SimpleDestination sourceToDestination(SimpleSource source);
    SimpleSource destinationToSource(SimpleDestination destination);
}
```
**Note**: Use `componentModel = "spring"` if you want to autowire.

### Mapping Different Field Names Example:
```java
@Mapping(target = "employeeId", source = "entity.id")
@Mapping(target = "employeeName", source = "entity.name")
EmployeeDTO employeeToEmployeeDTO(Employee entity);

@Mapping(target = "id", source = "dto.employeeId")
@Mapping(target = "name", source = "dto.employeeName")
Employee employeeDTOtoEmployee(EmployeeDTO dto);
```

### Mapping a List Example:
```java
List<EmployeeDTO> map(List<Employee> employees);
```

## Step 7: Lombok Integration
### Add These Properties:
```xml
<org.mapstruct.version>1.6.2</org.mapstruct.version>
<org.projectlombok.version>1.18.16</org.projectlombok.version>
<maven.compiler.source>1.8</maven.compiler.source>
<maven.compiler.target>1.8</maven.compiler.target>
```

### Add This Dependency:
- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)

### Add These Paths to Maven Compiler Plugin:
- [Lombok Maven](https://mvnrepository.com/artifact/org.projectlombok/lombok)
- [Lombok-MapStruct Maven](https://mvnrepository.com/artifact/org.projectlombok/lombok-mapstruct)

### Lombok Annotations:
- `@Getter`
- `@Setter`
- `@NoArgsConstructor`

## To-Do
- Logging
- Entity/Repository Tips
