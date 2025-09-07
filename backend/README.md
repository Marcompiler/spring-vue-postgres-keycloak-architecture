# Backend

## Description

The idea here is to develop a **[Java](https://en.wikipedia.org/wiki/Java_(programming_language))** application using the **[Spring](https://en.wikipedia.org/wiki/Spring_Framework)** framework.

This application will serve as a **[level 2 REST API](https://en.wikipedia.org/wiki/Richardson_Maturity_Model#Level_2:_HTTP_Verbs)**.  
It will also allow interaction with a PostgreSQL database via Spring JPA, which will manage entities and migrations.

### Why not fully RESTful?

**Initially, that was the plan.**

**However**, I realized that I **was mistaken** regarding the **RPC/REST/RESTful concepts** after reading [the Spring documentation](https://spring.io/guides/tutorials/rest) and discovering the [Richardson Maturity Model](https://en.wikipedia.org/wiki/Richardson_Maturity_Model).

Therefore, **to keep explanations "accessible" and the code "light"**, I decided to stay at the level of a **[level 2 REST API](https://en.wikipedia.org/wiki/Richardson_Maturity_Model#Level_2:_HTTP_Verbs)**.

Thus, **if you want**, I invite you to refer to **[this same documentation](https://spring.io/guides/tutorials/rest)** if you **need/want to develop a RESTful API** or, like me, **simply understand** what it really involves. From what I’ve seen, it seems fairly easy to adapt the code using their HATEOAS, and they explain it much better than I can.

## How to Use

### Project Creation

First, the project had to be **created**, so I used the **[following configuration](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.5.4&packaging=jar&jvmVersion=24&groupId=com.yourdomain&artifactId=backend&name=backend&description=Backend%20of%20the%20stack.&packageName=com.yourdomain.backend&dependencies=web,devtools,validation,data-jpa,configuration-processor,oauth2-resource-server,postgresql,security)** via [Spring Initializr](https://start.spring.io).

### Starting the Project

Next, **make sure** you have **started** the **database** and the **SSO** so that the backend can function.

**Open** the project **in IntelliJ IDEA** and **run** the project.

### Containerize

To **containerize your backend**, you can dive into the dedicated **[`podman`](./podman/)** directory here to start the process.
