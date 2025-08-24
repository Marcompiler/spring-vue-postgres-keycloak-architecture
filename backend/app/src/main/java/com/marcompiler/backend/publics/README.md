# Backend - App - Main - Java - Public

## Description

This is the **simplest part** of the application: **a simple controller** waiting for an HTTP request on a given **endpoint**.

It is indeed **the only endpoint** in the application **that does not require any authentication** with the API to interact with it.

It **allows you to verify**, in addition to understanding the basics of what makes this application an API, **that the API is working** by calling it from the frontend or a testing tool like HTTPie.

## How to Use

From the frontend or HTTPie, **call the controller endpoint**. By default, this is:

```sh
http://localhost:8081/api/public
```

You will then receive an **HTTP 200 (OK) response: "`Hello public`"**. This confirms that **your API is running and accessible**.
