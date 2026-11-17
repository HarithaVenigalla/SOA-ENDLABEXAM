# Tourist Record Update with Token Validation

Spring Boot REST API using PUT, Spring Data JPA, H2, and Swagger UI.

## Requirements
- Java 17+
- Maven 3.6+

## Run
In this project folder, execute:
```bash
mvn spring-boot:run
```
Or import as an existing Maven project in Spring Tool Suite / IntelliJ / Eclipse and run `TouristApplication.java`.

## Swagger
http://localhost:8080/swagger-ui/index.html

## Test API
- Method: PUT
- URL: http://localhost:8080/api/tourists/1
- Header: `Token: 000000000`
- Content-Type: `application/json`

Request body:
```json
{
  "name": "Haritha",
  "email": "haritha@example.com",
  "destination": "Hyderabad"
}
```

A sample tourist with ID 1 is inserted at startup.

Valid token returns HTTP 200 and the updated tourist JSON. Invalid/missing token returns HTTP 500 with `Invalid Token`, matching the assignment's stated behavior. HTTP 401 is generally preferable in production.
