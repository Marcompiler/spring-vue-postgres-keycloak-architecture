# Frontend - Podman

## Description

This folder contains **everything you may need to start containerizing** your frontend.

It includes a **`Containerfile`** to be used for **building the container image**, which you can then instantiate as many times as you want once created.

There is also a **`.dockerignore`** file to **exclude unnecessary elements** from the final image.

## How to use

Please note that **in its current state**, the files here are intended for a **generic deployment** in a **development environment**.

**For a production environment**, you should **adapt** the files **accordingly**, based in particular on [the dedicated Vue.js documentation](https://v2.vuejs.org/v2/cookbook/dockerize-vuejs-app.html?redirect=true#Real-World-Example).

### Containerfile and .dockerignore

First, you need to **copy two files** into the [root directory of the application](../app/):

- [`Containerfile`](./Containerfile): File used to **build the final image**.
- [`.dockerignore`](./.dockerignore): File defining **which elements should be excluded** from the image. (*Optional*)

### Build the image

**Once the above files are prepared** in the [root directory of the application](../app/), **run** the following command:

```sh
podman build --no-cache -t spring-vue-postgres-keycloak-architecture/frontend .
```

Where `spring-vue-postgres-keycloak-architecture/frontend` is the **name of the final image**.

### Deploy the image

**When your application image is created**, **run** the following command:

```sh
podman run -d --name frontend -p 8082:8080 localhost/spring-vue-postgres-keycloak-architecture/frontend
```

Your frontend will then be accessible through the default link: <http://localhost:8082>.
