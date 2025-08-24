# Podman (Keycloak)

## Description

This is where you'll find Keycloak-related stuff for instantiating Podman containers based on a Keycloak image.

Due to the advanced configuration that Keycloak allows, I have separated this folder into several environments, which are:

- [The development environment (DEV)](./dev/)
- [The production environment (PROD)](./prod/) (*untested*)

## How to use

**During the development phase**, simply instantiate containers with the [**DEV configuration**](./dev/) provided.
It is sufficiently comprehensive, based on the scope of this startup project, to test your use cases.

**When deploying in production**, I invite you to consider [**the corresponding dedicated section**](./prod/) to get an idea
of the path to take. However, I should point out that, as I have not yet been able to use this stack myself for
a production environment, I advise you to rely primarily on the [**official Keycloak documentation**](https://www.keycloak.org/getting-started/getting-started-podman#_taking_the_next_step).
