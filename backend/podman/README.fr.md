# Backend - Podman

## Description

Ce dossier contient tout ce dont vous pouvez avoir besoin pour entamer la conteneurisation de votre backend.

De ce fait, il contient un fichier `Containerfile` à utiliser pour constituer l'image du conteneur que vous pourrez instancier à souhait une fois créé.

Il y a également un fichier `.dockerignore` pour exclure des éléments hors de l'image finale.

## Comment utiliser

Je précise qu'en l'état actuel, les fichiers ici sont prévus pour un déploiement générique en environnement de développement.

Pour un environnement de production, veuillez adapter les fichiers en conséquence d'après, notamment, [la documentation de Vue.js dédiée](https://v2.vuejs.org/v2/cookbook/dockerize-vuejs-app.html?redirect=true#Real-World-Example).

### Containerfile et .dockerignore

Tout d'abord, il va falloir copier deux fichiers dans la racine du répertoire de l'application :

- [`Containerfile`](./Containerfile) : Fichier permettant de construire l'image finale.
- [`.dockerignore`](./.dockerignore) : Fichier définissant les éléments à exclure de l'image. (*Facultatif*)

### Construire l'image

Une fois les fichiers précédents préparés dans le [répertoire racine de l'application](../app/), exécutez la commande suivante dans ce même répertoire :

```sh
podman build --no-cache -t spring-vue-postgres-keycloak-architecture/backend .
```

Où `spring-vue-postgres-keycloak-architecture/backend` est le nom de l'image finale.

### Déployer l'image

Lorsque l'image de votre application est créée, exécutez la commande suivante :

```sh
podman run -d --name backend -p 8082:8080 localhost/spring-vue-postgres-keycloak-architecture/backend
```

Votre backend sera alors accessible au travers du lien par défaut : <http://localhost:8082>.
