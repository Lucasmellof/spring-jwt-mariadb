# Spring + JWT + MariaDB

I made this repo to study, so it should have errors or better ways to do some stuff. Feel free to open a [Pull Request](https://github.com/Lucasmellof/spring-jwt-mariadb/pulls) or create [Issues](https://github.com/Lucasmellof/spring-jwt-mariadb/issues/new).

## Technologies used

- [Java 17](https://openjdk.org/);
- [Spring Boot](https://spring.io/projects/spring-boot);
- [MariaDB](https://mariadb.org/);
- [Java JWT](https://github.com/auth0/java-jwt).

## How to run

- Just compile it using `mvn clean install`;
- Copy your file from `target/springus-1.0.0-SNAPSHOT.jar` to a nice place;
- And run using `java (PUT YOUR ENV VARIABLES HERE) -jar springus-1.0.0-SNAPSHOT.jar`

## Environment Variables
- `spring.datasource.url`: Your JDBC url
  - Ex: `-Dspring.datasource.url=jdbc:mariadb://localhost:3306/springus`
- `spring.datasource.username`: Your database username
  - Ex: `-Dspring.datasource.username=lucasmellof`
- `spring.datasource.password=supersecretpassword`: Your database password
  - Ex: `-Dspring.datasource.password=super`
- `springus.jwt_secret`: Your JWT secret token
  - Ex: `-Dspringus.jwt_secret=supersecretjwttoken`
- `springus.jwt_expiration_time`: Your JWT secret token (in seconds)
  - Ex: `-Dspringus.jwt_expiration_time=900000`