
# Java Spring Boot Quick Start

This guide provides a quick overview to set up a Spring Boot project using various plugins and dependencies, including `openapi-generator-maven-plugin` and H2 database.

## Maven Commands
- `mvn clean`
- `mvn install`
- `mvn clean install`
- `mvn spring-boot:run`
- `mvn clean install -DskipTests`

## Steps

### Step 1: Write the OpenAPI YAML
- Use the [Swagger Editor](https://editor.swagger.io/) to write your YAML file.

#### Tips:
- Name components with `NameDto` convention.
- Set `"readOnly: true"` for ID fields.
- Use `"required"` for mandatory fields.
- For date-only fields, use `"date"` instead of `"date-time"`.

### Step 2: Initialize the Spring Boot Project
Visit [Spring Initializr](https://start.spring.io/) and configure the project:
- **Project:** Maven
- **Language:** Java
- **Spring Boot Version:** 3.3.4
- **Project Metadata:**
  - **Packaging:** Jar
  - **Java Version:** 21

### Step 3: Configure `pom.xml`
- Refer to the [OpenAPI Generator Maven Plugin Documentation](https://openapi-generator.tech/docs/plugins) for more details.
- Add the following plugin configuration:

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
                  <!-- Customize these packages -->
                  <apiPackage>it.apuliadigital.album.api</apiPackage>
                  <modelPackage>it.apuliadigital.album.model</modelPackage>
                  <supportingFilesToGenerate>
                      ApiUtil.java
                  </supportingFilesToGenerate>
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

#### Add the Following Dependencies
- [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)
- [Jackson Databind Nullable](https://mvnrepository.com/artifact/org.openapitools/jackson-databind-nullable)
- [SpringDoc OpenAPI Starter WebMvc UI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui)

#### Access Swagger UI
- Open `http://localhost:8080/swagger-ui/index.html` in your browser.

### Step 4: Project Structure
Create the following folders in the same directory as `Application.java`:
- `controller`
- `entity`
- `service`
  - `impl`
- `repository`

We'll come back to these later.

### Step 5: Configure the H2 Database
#### Dependencies
- [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
- [H2 Database](https://mvnrepository.com/artifact/com.h2database/h2) (Make sure to remove the `<scope>test</scope>` to avoid exceptions.)

#### Properties
- **In-Memory Database:**
  
  ```properties
  spring.datasource.url=jdbc:h2:mem:testdb
  ```

- **Local Database:**
  
  ```properties
  spring.datasource.url=jdbc:h2:file:./data/demo
  ```

#### Additional Configuration
- Set the driver class:
  
  ```properties
  spring.datasource.driverClassName=org.h2.Driver
  ```

- Set the credentials:
  
  ```properties
  spring.datasource.username=sa
  spring.datasource.password=password
  ```

- Configure the dialect:
  
  ```properties
  spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
  ```

- Enable the H2 console:
  
  ```properties
  spring.h2.console.enabled=true
  ```

- Configure database creation or update:
  
  ```properties
  spring.jpa.hibernate.ddl-auto=create
  spring.jpa.hibernate.ddl-auto=validate
  ```

- Show SQL in the console:
  
  ```properties
  spring.jpa.show-sql=true
  ```

#### Access H2 Console
- Open `http://localhost:8080/h2-console` in your browser.

#### Change the Server Port
- To change the default port, add the following to `application.properties`:
  
  ```properties
  server.port=80
  ```
  Replace "80" with the desired port number.

### Step 6: Configure MapStruct
#### Dependencies
- [MapStruct](https://mvnrepository.com/artifact/org.mapstruct/mapstruct)

#### Plugin Configuration
Refer to the [MapStruct Website](https://mapstruct.org/) and add the following plugin to `pom.xml`:

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

#### Create a Mapper
1. Create a `mapper` folder in the same directory as `Application.java`.
2. Define a `Mapper` interface.

   Example:

   ```java
   @Mapper(componentModel = "spring")
   public interface SimpleSourceDestinationMapper {
       SimpleDestination sourceToDestination(SimpleSource source);
       SimpleSource destinationToSource(SimpleDestination destination);
   }
   ```

   **Note:** Use `componentModel = "spring"` if you want to enable autowiring.

## To-Do
- Implement logging functionality.
