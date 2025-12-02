```markdown
# Demo Spring Boot App (Expanded)

A small layered Spring Boot application demonstrating:
- DTOs
- Service layer
- JPA persistence with H2
- REST controller
- Sample data and tests

Requirements
- Java 17
- Maven

Build
```
mvn clean package
```

Run
```
mvn spring-boot:run
```
or
```
java -jar target/demo-springboot-app-0.0.1-SNAPSHOT.jar
```

API
- GET  /api/persons          -> list persons
- GET  /api/persons/{id}     -> get person
- POST /api/persons          -> create person (JSON body)
- PUT  /api/persons/{id}     -> update person (JSON body)
- DELETE /api/persons/{id}   -> delete person

H2 Console
- http://localhost:8080/h2-console
  - JDBC URL: jdbc:h2:mem:demo
  - user: sa
  - password: (empty)

Notes
- Sample data is loaded from src/main/resources/data.sql
- Change spring.jpa.hibernate.ddl-auto in application.properties for different schema handling
```