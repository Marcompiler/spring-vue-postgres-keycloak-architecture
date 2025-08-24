# Podman (Keycloak) - PROD

## Description

Here, the procedure is **more complex than for [DEV](../dev)**.
According to the [official Keycloak documentation](https://www.keycloak.org/server/containers#_creating_a_customized_and_optimized_container_image), the **best practice** is to **build your own Keycloak image** before using it in a container.

To summarize as much as possible, I will **summarize the procedure** in the [following section below](#how-to-use).
If further customization is required, please refer to the [official Keycloak documentation](https://www.keycloak.org/server/containers#_creating_a_customized_and_optimized_container_image).

## How to use

In short, you need to:

1. Using the [Containerfile template](Containerfile.template), **replace the values** according to your needs.
2. **Build the image** with the command: `podman build . -t mykeycloak`
3. Once the image is built, **create and start the container** using the [podman-compose.yml](podman-compose.yml) file, adapting it to your environment and the image you created.
   1. If you already have a database, simply comment out the “[db](podman-compose.yml#L16)” and “[adminer](podman-compose.yml#L24)” services. Also comment out the “[depends_on](podman-compose.yml#L7)” section of the oauth service.
   2. If you are using the “[db](podman-compose.yml#L16)” service, be sure to assign the same values as in the Containerfile for identifiers, etc.

*N.B.: At present, deployment in production has **not yet been tested**. I will first try to complete a production-worthy project myself with this stack before attempting it...*
