# Backend - App - Main - Java - Config - Security

## Description

A **major part** of the configuration: the **security** of the application.

In other words, this is where we configure what will **evaluate access to the application** by users and other applications.

There are two files:

- [`CorsConfig.java`](./CorsConfig.java): dedicated to managing [**Cross Origin Resource Sharing (*CORS*)**](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS). It defines **the [origins](https://developer.mozilla.org/en-US/docs/Web/Security/Same-origin_policy#definition_of_an_origin) allowed to call our application**, as well as the **[HTTP methods](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods) and [HTTP headers](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers) that are permitted**.
- [`SecurityConfig.java`](./SecurityConfig.java): dedicated to the application's **broader security**, defining both **public endpoints and those requiring authentication**. It also specifies how to retrieve **roles from the SSO** when using a [**JSON Web Token (*JWT*)**](https://en.wikipedia.org/wiki/JSON_Web_Token).

As it stands, [`CorsConfig.java`](./CorsConfig.java) only allows the frontend (*localhost:5173*) to communicate with our backend. In addition, public and authenticated endpoints have been defined, along with role extraction from the JWT based on the specifics of our SSO: Keycloak.

## How to use

The **default configuration** is **ready to use as is**. However, you can **adjust it** according to **your environment** and **your needs/preferences**.

If you want to **explore the configuration possibilities**, check out:

- [This article](https://howtodoinjava.com/spring-boot2/spring-cors-configuration/) for **CORS**.  
- [The official Spring documentation](https://docs.spring.io/spring-security/reference/servlet/configuration/java.html) for the **SecurityConfig** class.
