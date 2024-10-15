
# Java Spring Boot Quick Start Guide

This guide provides a quick start for setting up a Spring Boot project using OpenAPI, H2 database, and other essential tools.

## Prerequisites
- Java 21
- Maven

## Maven Commands
- `mvn clean`
- `mvn install` (equivalent to `mvn clean install`)
- `mvn spring-boot:run`
- `mvn clean install -DskipTests`

## Step 1: Write the OpenAPI YAML
- Use the [Swagger Editor](https://editor.swagger.io/)
- Tips:
    - Use `nameDto` for component names.
    - Set IDs as `readOnly: true`.
    - Use `required` for mandatory fields.
    - Use `date` (not `date-time`) to show only dates.
    - Avoid `nullable` to prevent generating `<JsonNullable>`.

## Step 2: Initialize a Spring Boot Project
- Go to [start.spring.io](https://start.spring.io/)
- Configuration:
    - Project: Maven
    - Language: Java
    - Spring Boot: 3.3.4
    - Packaging: Jar
    - Java: 21

## Step 3: Configure `pom.xml`
- Add the [OpenAPI Generator Maven Plugin](https://openapi-generator.tech/docs/plugins):
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
- Add these dependencies:
    - [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
    - [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)
    - [Jackson Databind Nullable](https://mvnrepository.com/artifact/org.openapitools/jackson-databind-nullable)
    - [SpringDoc OpenAPI Starter WebMVC UI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui)

- Access the Swagger UI at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Step 4: Create the Project Structure
- In the same folder as `Application.java`, create these folders:
    - `controller`
    - `entity`
    - `service/impl`
    - `repository`
    - `mapper`

## Step 5: Configure the H2 Database
- Add dependencies:
    - [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
    - [H2 Database](https://mvnrepository.com/artifact/com.h2database/h2) (Remove `<scope>test</scope>`)

- Properties configuration:
    ```properties
    # In-memory database
    spring.datasource.url=jdbc:h2:mem:testdb
    
    # Local file-based database
    spring.datasource.url=jdbc:h2:file:./data/demo
    
    # Driver and credentials
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=admin
    spring.datasource.password=password
    
    # Hibernate dialect and DDL
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    spring.jpa.hibernate.ddl-auto=create # or validate
    
    # H2 Console
    spring.h2.console.enabled=true
    
    # Show SQL in console
    spring.jpa.show-sql=true
    
    # Change server port (optional)
    server.port=8080
    ```

- Access the H2 Console at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## Step 6: Use MapStruct for Object Mapping
- Add dependencies:
    - [MapStruct](https://mvnrepository.com/artifact/org.mapstruct/mapstruct)
- Configure Maven Plugin:
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

- Example Mapper Interface:
    ```java
    @Mapper(componentModel = "spring")
    public interface SimpleSourceDestinationMapper {
        SimpleDestination sourceToDestination(SimpleSource source);
        SimpleSource destinationToSource(SimpleDestination destination);
    }
    ```
## Generate Client
- Aggiungi queste dipendenze nel `pom.xml`:
  - [JSR305](https://mvnrepository.com/artifact/com.google.code.findbugs/jsr305)
  - [Javax Annotation API](https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api)

- Aggiungi questa configurazione per il plugin `openapi-generator-maven-plugin`:
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
        </configuration>
    </execution>
    ```

- Nel file `Application.java`, aggiungi un `@Bean` per ogni API client:
    ```java
    @Bean
    public AlbumApi albumApiClient() {
        AlbumApi albumApiClient = new AlbumApi();
        albumApiClient.getApiClient().setBasePath("http://127.0.0.1:8081");
        return albumApiClient;
    }
    ```
  Ricorda di aggiornare la porta in base alla configurazione del server.

- All'interno dell'implementazione del servizio, utilizza `@Autowired` per iniettare i client API definiti nel `Application.java`.


## Additional To-Do
- Implement logging.
- Refer to [Spring Data Case Insensitive Queries](https://www.baeldung.com/spring-data-case-insensitive-queries) for further tips on entity/repository management.
- @Embedded annotation
