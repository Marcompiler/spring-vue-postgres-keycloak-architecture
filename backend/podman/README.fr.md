# Backend - Podman

## Description

Ce dossier contient **tout ce dont vous pouvez avoir besoin pour commencer à conteneuriser** votre backend.

Il inclut un **`Containerfile`** à utiliser pour **construire l'image du conteneur**, que vous pourrez ensuite instancier autant de fois que nécessaire une fois créée.

Il y a également un fichier **`.dockerignore`** permettant **d'exclure les éléments inutiles** de l'image finale.

## Comment utiliser

Veuillez noter qu'**en l'état actuel**, les fichiers présents ici sont prévus pour un **déploiement générique** dans un **environnement de développement**.

**Pour un environnement de production**, vous devrez **adapter** les fichiers **en conséquence**, en vous basant notamment sur [la documentation dédiée à Vue.js](https://v2.vuejs.org/v2/cookbook/dockerize-vuejs-app.html?redirect=true#Real-World-Example).

### Containerfile et .dockerignore

Tout d'abord, vous devez **copier deux fichiers** dans le [répertoire racine de l'application](../app/) :

- [`Containerfile`](./Containerfile) : fichier permettant de **construire l'image finale**.  
- [`.dockerignore`](./.dockerignore) : fichier définissant **les éléments à exclure** de l'image. (*Optionnel*)

### Construire l'image

**Une fois les fichiers préparés** dans le [répertoire racine de l'application](../app/), **exécutez** la commande suivante :

```sh
podman build --no-cache -t spring-vue-postgres-keycloak-architecture/backend .
```

Où `spring-vue-postgres-keycloak-architecture/backend` est le **nom de l'image finale**.

### Déployer l'image

**Une fois l'image de votre application créée**, **exécutez** la commande suivante (*sous PowerShell, remplacez `\` par `` ` ``*) :

```sh
podman run -d \
    --name backend \
    --net=host \
    -e SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres \
    -e SPRING_DATASOURCE_USERNAME=postgres \
    -e SPRING_DATASOURCE_PASSWORD=postgres \
    -e SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER-URI=http://localhost:8080/realms/demo-realm \
    -e SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK-SET-URI=http://localhost:8080/realms/demo-realm/protocol/openid-connect/certs \
    -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" \
    localhost/spring-vue-postgres-keycloak-architecture/backend
```

Votre backend sera alors accessible via le lien par défaut : <http://localhost:8081>.

*N.B. : `--net=host` est utilisé ici afin de pouvoir communiquer avec le SSO tout en étant conteneurisé sur la même machine.*