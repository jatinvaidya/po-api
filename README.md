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
| PUT /po/:id   | po:write       |
| DELETE /po/:id| po:delete      |

## Cross Origin Requests

This API is enabled for Cross Origin Requests (and pre-flight requests) from the following Origin only:  
`http://po-ui.jv-techex.com`

## Running Locally

#### Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- An Auth0 tenant and configuration of an API application (instructions not covered here).  
  (This API refers to the following Authorization Server: `jv-techex.auth0.com`)

```shell
cd po-api
gradlew bootRun
```
Port 8080 is used by default. To use a different port, add following property to application.yaml
```
server.port: <new-port>
```
*I have defined a `hosts` file entry to point `po-api.jv-techex.com` to `127.0.0.1`* 

## Sample Requests

- List Orders
```
curl -X GET \
  http://po-api.jv-techex.com:8080/api/v1/pos \
  -H 'Authorization: Bearer <access_token>'
```

- Fetch an Order
```
curl -X GET \
  http://po-api.jv-techex.com:8080/api/v1/po/1 \
  -H 'Authorization: Bearer <access_token>' \
  -H 'Accept: application/json'
```

- Create an Order
```
curl -X POST \
  http://po-api.jv-techex.com:8080/api/v1/po \
  -H 'Authorization: Bearer <access_token>' \
  -H 'Content-Type: application/json' \
  -d '{"itemId":"Heavy Duty Pump","quantity":10,"comment":"only 200 left in stock"}'
```

- Update an Order
```
curl -X PUT \
  http://po-api.jv-techex.com:8080/api/v1/po/3 \
  -H 'Authorization: Bearer <access_token>' \
  -H 'Content-Type: application/json'
  -d '{"itemId":"Heavy Duty Pump","quantity":20,"comment":"only 200 left in stock"}'
```

- Delete an Order
```
curl -X DELETE \
  http://po-api.jv-techex.com:8080/api/v1/po/1 \
  -H 'Authorization: Bearer <access_token>'
```