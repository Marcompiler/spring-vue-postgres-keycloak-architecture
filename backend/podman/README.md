# Backend - Podman

## Description

This folder contains everything you may need to start containerizing your backend.

It includes a `Containerfile` to be used for building the container image, which you can then instantiate as many times as you want once created.

There is also a `.dockerignore` file to exclude unnecessary elements from the final image.

## How to use

Please note that in its current state, the files here are intended for a generic deployment in a development environment.

For a production environment, you should adapt the files accordingly, based in particular on [the dedicated Vue.js documentation](https://v2.vuejs.org/v2/cookbook/dockerize-vuejs-app.html?redirect=true#Real-World-Example).

### Containerfile and .dockerignore

First, you need to copy two files into the root directory of your application:

- [`Containerfile`](./Containerfile): File used to build the final image. (*Mandatory*)
- [`.dockerignore`](./.dockerignore): File defining which elements should be excluded from the image.

### Build the image

Once the above files are prepared in the [root directory of the application](../app/), run the following command in that same directory:

```sh
podman build --no-cache -t spring-vue-postgres-keycloak-architecture/backend .
```

Where `spring-vue-postgres-keycloak-architecture/backend` is the name of the final image.

### Deploy the image

When your application image is created, run the following command (*for PowerShell, replace '\\' with '`'*):

```sh
podman run -d \
    --name backend \
    --net=host \
    -e SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres \
    -e SPRING_DATASOURCE_USERNAME=postgres \
    -e SPRING_DATASOURCE_PASSWORD=postgres \
    -e SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER-URI=http://localhost:8080/realms/demo-realm \
    -e SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK-SET-URI=http://localhost:8080/realms/demo-realm/protocol/openid-connect/certs \
    -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" \
    localhost/spring-vue-postgres-keycloak-architecture/backend
```

Your backend will then be accessible through the default link: <http://localhost:8082>.
