
# Java Spring Boot Quick Start
## Using OpenAPI Generator Maven Plugin and H2 Database

### Maven Commands
- `mvn clean`
- `mvn install`
- `mvn clean install`
- `mvn spring-boot:run`
- `mvn clean install -DskipTests`

### Step 1: Write YAML
Use the [Swagger Editor](https://editor.swagger.io/) to write your OpenAPI YAML.

**Tips:**
- Use `nameDto` to name components.
- IDs should have the property `"readOnly: true"`.
- If a component has required fields, use the `"required"` attribute.
- To show only the date, use `"date"` instead of `"date-time"`.
- Avoid using nullables, as they generate `<JsonNullable>`, which are difficult to handle. Instead, use required fields.

### Step 2: Initialize Spring Boot Project
Visit [Spring Initializr](https://start.spring.io/) to set up your project with the following options:
- **Project:** Maven
- **Language:** Java
- **Spring Boot:** 3.3.4
- **Project Metadata:**
  - **Packaging:** Jar
  - **Java:** 21

### Step 3: Edit `pom.xml`
Refer to [OpenAPI Generator Maven Plugin Documentation](https://openapi-generator.tech/docs/plugins) and add the following plugin to your `pom.xml`:

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
                <!-- Change this -->
                <apiPackage>it.apuliadigital.album.api</apiPackage>
                <modelPackage>it.apuliadigital.album.model</modelPackage>
                <supportingFilesToGenerate>
                    ApiUtil.java
                </supportingFilesToGenerate>
                <configOptions>
                    <!-- Specify that we are using Spring Boot 3 -->
                    <useSpringBoot3>true</useSpringBoot3>
                    <!-- We don't use the delegate pattern -->
                    <delegatePattern>false</delegatePattern>
                    <!-- We only want the interfaces -->
                    <interfaceOnly>true</interfaceOnly>
                </configOptions>
            </configuration>
        </execution>
    </executions>
</plugin>
```

**Add these dependencies:**
- [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)
- [Jackson Databind Nullable](https://mvnrepository.com/artifact/org.openapitools/jackson-databind-nullable)
- [SpringDoc OpenAPI Starter WebMVC UI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui)

**Access Swagger UI:**
- [Swagger UI](http://localhost:8080/swagger-ui/index.html)

### Step 4: Set Up Project Structure
In the same folder as `Application.java`, create the following packages:
- `controller`
- `entity`
- `service`
  - `impl`
- `repository`
- `mapper`

### Step 5: Set Up H2 Database
**Add these dependencies:**
- [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
- [H2 Database](https://mvnrepository.com/artifact/com.h2database/h2)  
  Note: Removing the `<scope>` property set to “test” is necessary to avoid exceptions.

**Database Properties:**
- **In-Memory Database:**
  ```properties
  spring.datasource.url=jdbc:h2:mem:testdb
  ```
- **Local Database:**
  ```properties
  spring.datasource.url=jdbc:h2:file:./data/demo
  ```
- **Set Driver:**
  ```properties
  spring.datasource.driverClassName=org.h2.Driver
  ```
- **Set Credentials:**
  ```properties
  spring.datasource.username=admin
  spring.datasource.password=password
  ```
- **Set Dialect:**
  ```properties
  spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
  ```
- **Enable Console:**
  ```properties
  spring.h2.console.enabled=true
  ```
- **Create or Update Database:**
  ```properties
  spring.jpa.hibernate.ddl-auto=create
  spring.jpa.hibernate.ddl-auto=validate
  ```
- **Show SQL in Console:**
  ```properties
  spring.jpa.show-sql=true
  ```

**Access H2 Console:**
- [H2 Console](http://localhost:8080/h2-console)

**Change Port:**  
If you want to change the port, add the following line in `application.properties`:
```properties
server.port=80  # Replace “80” with the desired port
```


### Step 6: MapStruct
**Dependencies:**
- [MapStruct](https://mvnrepository.com/artifact/org.mapstruct/mapstruct)

**Plugin Configuration:**
Add the following plugin to your `pom.xml`:

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

**Create a Mapper Interface:**
Inside the `mapper` folder, create a Mapper interface.

**Example:**
```java
@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {
    SimpleDestination sourceToDestination(SimpleSource source);
    SimpleSource destinationToSource(SimpleDestination destination);
}
```

**Note:** Use `componentModel = "spring"` if you want to autowire the mapper.

**Mapping Different Field Names:**
```java
@Mapping(target = "employeeId", source = "entity.id")
@Mapping(target = "employeeName", source = "entity.name")
EmployeeDTO employeeToEmployeeDTO(Employee entity);

@Mapping(target = "id", source = "dto.employeeId")
@Mapping(target = "name", source = "dto.employeeName")
Employee employeeDTOtoEmployee(EmployeeDTO dto);
```

**To Map a List:**
```java
List<EmployeeDTO> map(List<Employee> employees);
```

**Using the Mapper:**
The mapper is usually used inside the `@Service`, so remember to `@Autowire` the mapper.

### Lombok
**Add these properties to your `pom.xml`:**
```xml
<org.mapstruct.version>1.6.2</org.mapstruct.version>
<org.projectlombok.version>1.18.16</org.projectlombok.version>
<maven.compiler.source>1.8</maven.compiler.source>
<maven.compiler.target>1.8</maven.compiler.target>
```

**Add this dependency:**
- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)

**Inside `maven-compiler-plugin`, add these two paths:**
- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
- [Lombok-MapStruct](https://mvnrepository.com/artifact/org.projectlombok/lombok-mapstruct)

**Use these Annotations:**
- `@Getter`
- `@Setter`
- `@NoArgsConstructor`

### Generate Client
To generate the client, only include the following folders:
- `controller`
- `mapper`
- `service`

**Inside `pom.xml`, add these dependencies:**
- [JSR305](https://mvnrepository.com/artifact/com.google.code.findbugs/jsr305)
- [Javax Annotation API](https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api) (*)
- [JUnit Jupiter API](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api) (Use this dependency to avoid skipping tests)

**Inside the `openapi-generator-maven-plugin`, add these executions:**
```xml
<execution>
    <id>generate-client-album</id>
    <goals>
        <goal>generate</goal>
    </goals>
    <configuration>
        <inputSpec>${project.basedir}/src/main/resources/album.yaml</inputSpec>
        <generatorName>java</generatorName>
        <apiPackage>it.giovanniromano.portale.client.album.api</apiPackage>
        <modelPackage>it.giovanniromano.portale.client.album.model</modelPackage>
        <library>resttemplate</library>
        <!-- (*) USE THIS CONFIG OPTION ONLY IF YOU DON'T HAVE THE javax.annotation-api DEPENDENCY -->
        <configOptions>
            <useJakartaEe>true</useJakartaEe>
        </configOptions>
    </configuration>
</execution>
```

**Inside `Application.java`, add a `@Bean` for each API Client:**
**Example:**
```java
@Bean
public AlbumApi albumApiClient() {
    AlbumApi albumApiClient = new AlbumApi();
    albumApiClient.getApiClient().setBasePath("http://127.0.0.1:8081");
    return albumApiClient;
}
```

**Note:** Specify the port where the server is running in the line `albumApiClient.getApiClient().setBasePath("http://127.0.0.1:8081");`, and remember to change the ports in the running clients.

**Inside the Service Implementation, `@Autowire` the API Client Beans declared inside `Application`.**

### Guidelines
1. Start with the controller (implement the only API interface generated).
2. Use the return value in the controller to generate the services.
3. Generate mappers.

### Logger
Refer to [Spring Boot Logging Example](https://mkyong.com/spring-boot/spring-boot-logging-example/).
Inside the controller:
```java
Logger logger = LoggerFactory.getLogger(AnagraficaController.class);
```

### Other Resources
Ignore this :P
- **Entity/Repository Tips:** [Case-Insensitive Queries](https://www.baeldung.com/spring-data-case-insensitive-queries)
- [Dockerizing Your Spring Boot Application](https://www.linkedin.com/pulse/dockerizing-your-spring-boot-application-step-by-step-rathore-ez1he)
- **Mongo and Docker**
