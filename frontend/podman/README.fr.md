# Frontend - Podman

## Description

Ce dossier contient **tout ce dont vous pouvez avoir besoin pour commencer à conteneuriser** votre frontend.

Il inclut un **`Containerfile`** à utiliser pour **construire l'image du conteneur**, que vous pourrez ensuite instancier autant de fois que nécessaire une fois créée.

Il y a également un fichier **`.dockerignore`** permettant **d'exclure les éléments inutiles** de l'image finale.

## Comment utiliser

Veuillez noter qu'**en l'état actuel**, les fichiers présents ici sont prévus pour un **déploiement générique** dans un **environnement de développement**.

**Pour un environnement de production**, vous devrez **adapter** les fichiers **en conséquence** d'après, notamment, [la documentation de Vue.js dédiée](https://v2.vuejs.org/v2/cookbook/dockerize-vuejs-app.html?redirect=true#Real-World-Example).

### Containerfile et .dockerignore

Tout d'abord, vous devez **copier deux fichiers** dans le [répertoire racine de l'application](../app/) :

- [`Containerfile`](./Containerfile) : fichier permettant de **construire l'image finale**.  
- [`.dockerignore`](./.dockerignore) : fichier définissant **les éléments à exclure** de l'image. (*Optionnel*)

### Construire l'image

**Une fois les fichiers préparés** dans le [répertoire racine de l'application](../app/), **exécutez** la commande suivante :

```sh
podman build --no-cache -t spring-vue-postgres-keycloak-architecture/frontend .
```

Où `spring-vue-postgres-keycloak-architecture/frontend` est le nom de l'image finale.

### Déployer l'image

**Une fois l'image de votre application créée**, **exécutez** la commande suivante :

```sh
podman run -d --name frontend -p 8082:8080 localhost/spring-vue-postgres-keycloak-architecture/frontend
```

Votre frontend sera alors accessible au travers du lien par défaut : <http://localhost:8082>.
