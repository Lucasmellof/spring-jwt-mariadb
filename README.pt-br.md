# Spring + JWT + MariaDB

🌍 Clique [aqui](https://github.com/Lucasmellof/spring-jwt-mariadb/blob/main/README.pt-br.md) para uma versão em Inglês(US).

Fiz esse projeto para estudar, então podem ter erros ou uma melhor forma de fazer as coisas. Seja bem-vindo para abrir um  [Pull Request](https://github.com/Lucasmellof/spring-jwt-mariadb/pulls) ou criar uma [Issue](https://github.com/Lucasmellof/spring-jwt-mariadb/issues/new).

## Tecnologias usadas

- [Java 17](https://openjdk.org/);
- [Spring Boot](https://spring.io/projects/spring-boot);
- [MariaDB](https://mariadb.org/);
- [Java JWT](https://github.com/auth0/java-jwt).

## Como executar

- Compile o projeto usando: `mvn clean install`;
- Copie o arquivo de `target/springus-1.0.0-SNAPSHOT.jar` para um ótimo local;
- Execute essas queries no seu banco de dados:
  ```
  INSERT INTO roles(name) VALUES('ROLE_USER');
  INSERT INTO roles(name) VALUES('ROLE_ADMIN');
  ```
- Execute usando `java (COLOQUE AS VARIÁVEIS DE AMBIENTE AQUI) -jar springus-1.0.0-SNAPSHOT.jar`.

## Variáveis de ambiente.
- `spring.datasource.url`: A URL do JDBC
  - Ex: `-Dspring.datasource.url=jdbc:mariadb://localhost:3306/springus`
- `spring.datasource.username`: O usuário do seu banco de dados.
  - Ex: `-Dspring.datasource.username=lucasmellof`
- `spring.datasource.password=supersecretpassword`: A senha do seu banco de dados.
  - Ex: `-Dspring.datasource.password=super`
- `springus.jwt_secret`: A chave secreta do JWT.
  - Ex: `-Dspringus.jwt_secret=supersecretjwttoken`
- `springus.jwt_expiration_time`: O tempo de expiração da chave JWT (em segundos)
  - Ex: `-Dspringus.jwt_expiration_time=900000`
