# Backend - App - Main - Java - Config

## Description

**Application configuration** cannot be done solely through [`application.properties`](../../../../../resources/application.properties); it must also be handled **in part through the application code itself**.

Here, there are two main aspects of this configuration:

- **Data persistence**.  
- **Application security**.

**Security** has its [**dedicated folder**](./security/) since there are several elements related to it. **Persistence**, on the other hand, is configured using this single file: [**`PersistenceConfig.java`**](./PersistenceConfig.java).

## How to Use

The **default configuration** can obviously be **used as-is**.

Based on the [official Spring documentation](https://docs.spring.io/spring-data/jpa/docs/current/api/index.html), you can **adjust/modify** the annotations and contents of [**`PersistenceConfig.java`**](./PersistenceConfig.java) to best suit your environment.
