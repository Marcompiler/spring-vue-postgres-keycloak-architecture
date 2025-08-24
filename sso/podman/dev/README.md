# Podman (Keycloak) - DEV

## Description

Here you will find the elements necessary to instantiate a Podman Keycloak container for the **development environment**.

By default, the **Keycloak** instance is **deployed** at the address <http://localhost:8080>.

## How to use

The command to run to create/start the container is therefore:

```sh
podman compose -f podman-compose.yml up -d
```

To **only** stop it:

```sh
podman stop keycloak-dev
```

To stop **and** destroy it:

```sh
podman compose -f podman-compose.yml down
```
