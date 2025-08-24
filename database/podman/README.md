# Database - Podman

## Description

This is where you have everything needed to deploy a PostgreSQL database easily using [Podman](https://podman.io/).

## How to Use

Starting from the [`.env.database.template`](./.env.database.template) file, **create your own `.env.database`**.

Enter the data you want. However, **if you change the default values**, make sure to reflect them in the [backend configuration](../../backend/app/src/main/resources/application.properties).

Once your `.env.database` file is created, you can open a command prompt in this folder to **run the following command**:

```sh
podman-compose -f podman-compose.yml up -d
```

This will deploy your database in a container accessible at the port you chose (_by default, `5432`_).
