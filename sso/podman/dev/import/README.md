# Podman (Keycloak) - DEV - Import

## Description

Here is an **export of the realm** mentioned earlier **for your tests with Keycloak**.

The realm includes user groups, roles, etc. allowing you to test the features of the rest of this repository.

## How to use

**When you start the Podman Keycloak DEV container** using the dedicated [`podman-compose.yml`](../podman-compose.yml), **this export will be automatically imported** into the Keycloak container using the `--import-realm` command and the mount point with this folder.
