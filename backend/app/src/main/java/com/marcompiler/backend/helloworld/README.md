# Backend - App - Main - Java - HelloWorld

## Description

The classic **["Hello world"](https://en.wikipedia.org/wiki/Hello_world)**.  
*It obviously had to be included in a starter project like this one.*

This directory allows you to **quickly get familiar with the key concepts** frequently used in an API, where each has its own role:

- **Entities with [`HelloWorld.java`](./HelloWorld.java)**. They represent the **data structures**.  
- **Controllers with [`HelloWorldController.java`](./HelloWorldController.java)**. They act as a **controlled bridge between actions on the database data** and the outside world.  
- **Repositories with [`HelloWorldRepository.java`](./HelloWorldRepository.java)**. The API must go through them to **interact directly with the database**. The **controllers** only handle **control**, while the **repositories** perform the actual **actions**.  
- A **data initializer [`HelloWorldDataInitializer.java`](./HelloWorldDataInitializer.java)**. These are generally used for the first startup of the application so that it can be **deployed with data** in the database, including data **necessary** for proper functioning and/or basic use of the application by users.

## How to Use

Here, the goal is to **observe the data initialization** handled by the [initializer](./HelloWorldDataInitializer.java) **when the API starts**.

**Once the API is running**, you can **manipulate/retrieve the [entities](./HelloWorld.java)** via the [controller](./HelloWorldController.java), which calls the [repository](./HelloWorldRepository.java) to modify/retrieve the saved data.

To do this, **authenticate with the SSO**, **obtain the [Json Web Token (*JWT*)](https://en.wikipedia.org/wiki/JSON_Web_Token)**, and **include it in your request** to one of the API endpoints, such as in this case:

```sh
http://localhost:8081/api/helloworld
```

You will then receive an **HTTP 200 (OK) response: "`Hello world`"**.  
This confirms that **your API is running and accessible via authentication**.
