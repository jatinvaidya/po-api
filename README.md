# po-api - Purchase Order Management API
This is a simple CRUD API based on Spring Boot for demo purposes
It uses an in-memory database (H2) for ephemeral storage. Data will be wiped out upon service shutdown.
API is protected using OAuth 2.0 (details TBD)

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## Running the application locally

```shell
gradlew bootRun
```
Port 8080 is used by default. To use a different port, add following property to application.yaml
```
server.port: <new-port>
```
