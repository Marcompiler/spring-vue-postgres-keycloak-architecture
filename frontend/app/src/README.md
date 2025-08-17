# Frontend - App - Src

## Description

Ici se trouve la partie du code dans laquelle on passe le plus clair de notre temps pour développer l'application frontend.

Celle-ci contient donc les répertoires et éléments de base générés par Vue.JS.

### Keycloak

Pour pouvoir lier notre frontend au SSO, un **fichier supplémentaire** a été ajouté : [**`keycloak.js`**](./keycloak.js). Ce fichier JavaScript est un [**adapteur fourni par Keycloak**](https://www.keycloak.org/securing-apps/javascript-adapter) permettant de **lier** l'instance du **SSO** avec notre **frontend** afin que ce dernier puis rediriger et se servir du SSO pour l'authentification de ses utilisateurs.

**Dans** le script principal [**`main.js`**](./main.js), il a donc fallut **ajouter une section** pour obliger les utilisateurs à s'authentifier au sein de l'application.

## Comment utiliser

Chaque répertoire a son but :

- [`assets`](./assets/) : stocke les éléments de type **CSS et médias** (*images, vidéos, etc.*) **référencés au sein de l'application**. On les stocke là afin de séparer la logique métier des éléments qu'elle manipule dans l'affichage.
- [`components`](./components/) : contient **l'ensemble des composants** utilisés et réutilisables au sein de l'application.
- [`router`](./router/) : contient l'indexeur des pages de l'application. C'est lui qui détermine les chemins menant à des pages de l'application ainsi que le composant "page" correspondant.
- [`views`](./views/) : les **vues de l'application** qui, même si elles sont elles-mêmes des composants, sont distinguées des autres composants de par leur but principal : être une **page accessible de par** le contenu de **[`router`](./router/)**.
