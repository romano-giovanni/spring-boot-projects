# Java Spring Boot Quick Start
Using OpenAPI Generator Maven Plugin, H2 Database
```raw

 ________  ________  _____ ______   ________  ________   ________     
|\   __  \|\   __  \|\   _ \  _   \|\   __  \|\   ___  \|\   __  \    
\ \  \|\  \ \  \|\  \ \  \\\__\ \  \ \  \|\  \ \  \\ \  \ \  \|\  \   
 \ \   _  _\ \  \\\  \ \  \\|__| \  \ \   __  \ \  \\ \  \ \  \\\  \  
  \ \  \\  \\ \  \\\  \ \  \    \ \  \ \  \ \  \ \  \\ \  \ \  \\\  \ 
   \ \__\\ _\\ \_______\ \__\    \ \__\ \__\ \__\ \__\\ \__\ \_______\
    \|__|\|__|\|_______|\|__|     \|__|\|__|\|__|\|__| \|__|\|_______|
                                                                      
```
                                                                      

## Maven Commands
- `mvn clean`
- `mvn install` (also `mvn clean install`)
- `mvn spring-boot:run`
- `mvn clean install -DskipTests`

## Write YAML
To create your YAML file, use the [Swagger Editor](https://editor.swagger.io/).

### Tips:
- Use `nameDto` to name components.
- IDs should have the `"readOnly: true"` property.
- If a component has required fields, use `"required"`.
- To show only the date, use `"date"` instead of `"date-time"`.
- Nullables generate `<JsonNullable>`, which can be difficult to handle. It's best to avoid using nullable types and instead use required fields.

## Create Spring Boot Project
Go to [Spring Initializr](https://start.spring.io/) and set the following options:
- **Project**: Maven
- **Language**: Java
- **Spring Boot**: 3.3.4
- **Project Metadata**:
    - **Packaging**: Jar
    - **Java**: 21

## Folder Structure
In the same folder as `Application.java`, create the following structure:

- `controller`
- `entity`
- `service`
    - `impl`
- `repository`
- `mapper`

## Generate Server
1. Edit `pom.xml` as follows:
   Visit the [OpenAPI Generator Maven Plugin documentation](https://openapi-generator.tech/docs/plugins) and add this plugin:
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
                   <inputSpec>
                   <!-- change this -->
                       ${project.basedir}/src/main/resources/openapi.yaml
                   </inputSpec>
                   <generatorName>spring</generatorName>
                   <!-- change these -->
                   <apiPackage>com.example.demo.server.api</apiPackage>
                   <modelPackage>com.example.demo.server.model</modelPackage>
                   <supportingFilesToGenerate>
                       ApiUtil.java
                   </supportingFilesToGenerate>
                   <configOptions>
                       <!-- specify that we are using SpringBoot3 -->
                       <useSpringBoot3>true</useSpringBoot3>
                       <!-- we don't use delegate pattern -->
                       <delegatePattern>false</delegatePattern>
                       <!-- we only want the interfaces -->
                       <interfaceOnly>true</interfaceOnly>
                   </configOptions>
               </configuration>
           </execution>
       </executions>
   </plugin>
2. Add these dependencies to `pom.xml`:
    - [Jackson Databind Nullable](https://mvnrepository.com/artifact/org.openapitools/jackson-databind-nullable)
    - [Springdoc OpenAPI Starter Web MVC UI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui)

   These dependencies are already included in the `pom.xml`:
    - [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
    - [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)

3. Access Swagger UI at:
    - `http://localhost:8080/swagger-ui/index.html`

## Generate Client

1. Ensure you have the following folders:
    - `controller`
    - `mapper`
    - `service`

2. Inside `pom.xml`, add these dependencies:
    - [JSR 305](https://mvnrepository.com/artifact/com.google.code.findbugs/jsr305)
    - [Javax Annotation API](https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api) (*)
    - [JUnit Jupiter API](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api) (use this dependency to avoid skipping tests)

3. Inside the `openapi-generator-maven-plugin`, add this execution (or more, depending on the number of clients you want to generate):

   ```xml
   <execution>
       <id>generate-client-album</id>
       <goals>
           <goal>generate</goal>
       </goals>
       <configuration>
           <inputSpec>${project.basedir}/src/main/resources/album.yaml</inputSpec>
           <generatorName>java</generatorName>
           <apiPackage>com.example.demo.client.api</apiPackage>
           <modelPackage>com.example.demo.client.model</modelPackage>
           <library>resttemplate</library>
           <!-- USE THIS ONLY IF YOU DON'T HAVE THE javax.annotation-api DEPENDENCY -->
           <configOptions>
               <useJakartaEe>true</useJakartaEe>
           </configOptions>
       </configuration>
   </execution>
4. Inside `Application.java`, add a `@Bean` for each API Client. For example:

   ```java
   @Bean
   public AlbumApi albumApiClient() {
       AlbumApi albumApiClient = new AlbumApi();
       albumApiClient.getApiClient().setBasePath("http://127.0.0.1:8081");
       return albumApiClient;
   }
Note: The line `albumApiClient.getApiClient().setBasePath("http://127.0.0.1:8081");` specifies the port where the server is running, so remember to change the ports in the running clients.

Inside the Service implementation, `@Autowired` the API Client Beans declared inside `Application`.

### Guideline
1. Start from the controller (implement the only API interface generated).
2. Use the return value in the controller to generate the services.
3. Generate mappers.

## H2 Database

### Set Database H2

**Dependencies:**
- [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
- [H2 Database](https://mvnrepository.com/artifact/com.h2database/h2)
    - The `<scope>` property set to "test" generates an exception; remove the property.

### Properties
Ecco le proprietà da copiare:

```properties
# Database in Memory
spring.datasource.url=jdbc:h2:mem:testdb

# Database in Local
spring.datasource.url=jdbc:h2:file:./data/demo

# Set Driver
spring.datasource.driverClassName=org.h2.Driver

# Set Credentials
spring.datasource.username=admin
spring.datasource.password=password

# Set Dialect
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Set Console
spring.h2.console.enabled=true

# Create Database or Update
spring.jpa.hibernate.ddl-auto=create
spring.jpa.hibernate.ddl-auto=validate

# Show SQL in Console
spring.jpa.show-sql=true
```
### Access H2 Console
Access the H2 console at:
- `http://localhost:8080/h2-console`

### Change Port
If you want to change the port, in `application.properties` do this:
- `server.port=80` (replace "80" with the desired port)

## MapStruct

1. **Add this dependency:**
    - [MapStruct](https://mvnrepository.com/artifact/org.mapstruct/mapstruct)

2. **Add the plugin to `pom.xml`:**
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
### Mapper Interface

Inside the `mapper` folder, create a Mapper interface:

```java
@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {
    SimpleDestination sourceToDestination(SimpleSource source);
    SimpleSource destinationToSource(SimpleDestination destination);
}
```
**Note:** Use `componentModel = "spring"` if you want to autowire.

### When Mapping Different Field Names
```java
@Mapping(target = "employeeId", source = "entity.id")
@Mapping(target = "employeeName", source = "entity.name")
EmployeeDTO employeeToEmployeeDTO(Employee entity);

@Mapping(target = "id", source = "dto.employeeId")
@Mapping(target = "name", source = "dto.employeeName")
Employee employeeDTOtoEmployee(EmployeeDTO dto);
```
### To Map a List
```java
List<EmployeeDTO> map(List<Employee> employees);
```
**Note:** The mapper is usually used inside the `@Service`, so remember to `@Autowire` the mapper.

## Logger

For logging in Spring Boot, you can follow this example: [Spring Boot Logging Example](https://mkyong.com/spring-boot/spring-boot-logging-example/).

Inside the controller and service implementation, add the following:

```java
Logger logger = LoggerFactory.getLogger(AnagraficaController.class);
```
Inside `application.properties`, configure the logging settings:
```properties
logging.file.path=.
logging.file.name=logfile.log
logging.level.root=error
# trace, debug, info, warning, error
```
## Spring Boot and Docker

For more information, visit: [Dockerizing Your Spring Boot Application](https://www.linkedin.com/pulse/dockerizing-your-spring-boot-application-step-by-step-rathore-ez1he)

1. Generate a `.jar` file:
   ```bash
   mvn clean install 
- If you want to change the `.jar` name, add the following inside `<build>` in your `pom.xml`:
  ```xml
  <finalName>newName</finalName>
  ```
2. Create a `Dockerfile`:
   ```dockerfile
   # Use OpenJDK 21 as the base image
   FROM openjdk:21
   
   # If you prefer to use Java 17, change the base image to openjdk:17
   # FROM openjdk:17
   
   # Add the JAR file to the container
   ADD target/demo.jar demodkr.jar
   
   # Expose port 8080
   EXPOSE 8080
   
   # Set the entry point for the application
   ENTRYPOINT [ "java", "-jar", "demodkr.jar" ]

3. Generate Docker image:
  ```bash
  docker build -t demodkr/latest .
  ```
4. Inside the Docker Desktop app, run the image, create a container, and set the port (e.g., :8080).

Learn more useful commands at:
- [Useful Commands by Pier](https://gist.github.com/P13rLu1/643ef6d46439560df2bbef00d78e7c41)

Made with ❤️ from Pier.


## REST Template
Use this sample code by Silvio ;)
- [Sample Code](https://gist.github.com/romano-giovanni/2f5c5977aa8073b22a07b1cee573682d)

## Lombok
1. Add these properties:
   ```xml
   <org.mapstruct.version>1.6.2</org.mapstruct.version>
   <org.projectlombok.version>1.18.16</org.projectlombok.version>
   <maven.compiler.source>1.8</maven.compiler.source>
   <maven.compiler.target>1.8</maven.compiler.target>
   ```
2. Add this dependency:
    - [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
3. Inside the `maven-compiler-plugin`, add these two paths:
    - [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
    - [Lombok MapStruct](https://mvnrepository.com/artifact/org.projectlombok/lombok-mapstruct)
4. Use these annotations inside entities:
    - `@Getter`
    - `@Setter`
    - `@NoArgsConstructor`

## EXTRA TIPS
1. Create a `banner.txt`:
    - You can use this resource to create a cool graphic:
        - [Spring Boot Banner Generator](https://springhow.com/spring-boot-banner-generator/)
    - Place the `banner.txt` file inside the `resources` folder.


## Misc

Links:
- [Spring Data Case Insensitive Queries](https://www.baeldung.com/spring-data-case-insensitive-queries)
- [Java OpenAPI Generator Server](https://www.baeldung.com/java-openapi-generator-server)
- [Spring Boot H2 Database](https://www.baeldung.com/spring-boot-h2-database)
- [MapStruct Guide](https://www.baeldung.com/mapstruct)
- [MapStruct Custom Mapper](https://www.baeldung.com/mapstruct-custom-mapper)
- [Install MongoDB Community with Docker](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-community-with-docker/)
- [Getting Started with MongoDB and Spring Boot](https://www.mongodb.com/resources/products/compatibilities/spring-boot#getting-started-with-mongodb-and-spring-boot)
- [Spring Boot Logging Example](https://mkyong.com/spring-boot/spring-boot-logging-example/)
- [Exception Handling in Spring MVC](https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc)
- [Spring Boot Exception Handling](https://www.tutorialspoint.com/spring_boot/spring_boot_exception_handling.htm)
- [Exception Handling for REST with Spring](https://www.baeldung.com/exception-handling-for-rest-with-spring)
- [Spring Boot with Keycloak](https://www.baeldung.com/spring-boot-keycloak)
- [Securing Spring Boot with Keycloak](https://medium.com/@wahyubagus1910/securing-spring-boot-with-keycloak-b352f05575f2)
- [JPA Relationships Example](https://github.com/codeforgeyt/jpa-relationships)
