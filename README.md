# Java Spring Boot Quick Start

## Maven Commands
- **Clean the project**: 
  ```bash
  mvn clean
  ```
- **Install the project**: 
  ```bash
  mvn install
  ```
  - Combined command:
    ```bash
    mvn clean install
    ```
- **Run the application**: 
  ```bash
  mvn spring-boot:run
  ```
- **Install the project while skipping tests**: 
  ```bash
  mvn clean install -DskipTests
  ```

## Step 1: Create a New Project
1. Go to [Spring Initializr](https://start.spring.io/).
2. Fill in the project metadata:
   - **Project**: Maven
   - **Language**: Java
   - **Spring Boot**: 3.3.4
   - **Project Metadata**:
     - **Packaging**: Jar
     - **Java Version**: 21

## Step 2: Edit `pom.xml`
1. Add the following plugin:
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
                       <!-- We don't use delegate pattern -->
                       <delegatePattern>false</delegatePattern>
                       <!-- We only want the interfaces -->
                       <interfaceOnly>true</interfaceOnly>
                   </configOptions>
               </configuration>
           </execution>
       </executions>
   </plugin>
   ```

2. Add these dependencies:
   - [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
   - [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)
   - [Jackson Databind Nullable](https://mvnrepository.com/artifact/org.openapitools/jackson-databind-nullable)
   - [SpringDoc OpenAPI Starter WebMVC UI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui)

## Step 3: Set Up the Project Structure
Create the following folders in the same directory as `Application.java`:
- `controller`
- `entity`
- `service`
  - `impl`
- `repository`

## Step 4: Set Up H2 Database
### Dependencies
- [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
- [H2 Database](https://mvnrepository.com/artifact/com.h2database/h2)
 **Remove Scope property**

### Properties
- **In-memory Database**:
  ```properties
  spring.datasource.url=jdbc:h2:mem:testdb
  ```
- **Local Database**:
  ```properties
  spring.datasource.url=jdbc:h2:file:./data/demo
  ```
- **Set Driver**:
  ```properties
  spring.datasource.driverClassName=org.h2.Driver
  ```
- **Set Credentials**:
  ```properties
  spring.datasource.username=sa
  spring.datasource.password=password
  ```
- **Set Dialect**:
  ```properties
  spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
  ```
- **Enable H2 Console**:
  ```properties
  spring.h2.console.enabled=true
  ```
- **Create or Update Database**:
  ```properties
  spring.jpa.hibernate.ddl-auto=create
  ```
  (or for validation)
  ```properties
  spring.jpa.hibernate.ddl-auto=validate
  ```
- **Show SQL in Console**:
  ```properties
  spring.jpa.show-sql=true
  ```

### Access the H2 Console
You can access the H2 console at:
```
http://localhost:8080/h2-console
```

