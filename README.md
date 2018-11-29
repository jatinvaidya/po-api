# Purchase Order Management API

This is a simple RESTful CRUD API based on Spring Boot to demonstrate **OAuth 2.0 Resource Server** (secure API).  
It uses an in-memory database (H2) for ephemeral storage. Data will be wiped out upon service shutdown.

## Configuration Details

This API expects OAuth 2.0 Bearer `access_token` in `JWT` format.
It can locally validate the JWT `access_token` referring to the PKI keys on `jwks` URI.
Currently the `jwks` URI for the following Auth0 tenant is configured: `jv-techex.auth0.com`

## Access Control

**Fine Grained Authorization** is enforced on CRUD operations based on `scopes` in the `access_token` as follows.

| API call      | Required Scope |
| ------------- | -------------- |
| GET /pos      | po:read        |
| GET /po/:id   | po:read        |
| POST /po      | po:write       |
| PUT /po/:ID   | po:write       |
| DELETE /po/:id| po:delete      |

## Running Locally

#### Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- An Auth0 tenant and configuration of an API application (instructions not covered here).

```shell
cd po-api
gradlew bootRun
```
Port 8080 is used by default. To use a different port, add following property to application.yaml
```
server.port: <new-port>
```

## Sample Requests

Coming soon.
