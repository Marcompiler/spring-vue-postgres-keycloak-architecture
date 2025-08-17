# Architecture Web - Exemple Spring-Vue-Postgres-Keycloak

## Description

Ce repository est une **architecture permettant de développer un site Web complet** avec tous les éléments nécessaires : un **backend**, un **frontend**, une **base de données** et une **authentification unique**.

### Architecture

L'architecture est donc constituée de la façon suivante :

- [Un backend API RPC](./backend/README.md)
  - [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
  - [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/index.html)
  - [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
- [Un frontend](./frontend/README.md)
  - [Vue.JS](https://vuejs.org/)
- [Une authentification unique (SSO)](./sso/README.md)
  - [Keycloak](https://www.keycloak.org/)
- [Une base de données](./database/)
  - [PostgreSQL](https://fr.wikipedia.org/wiki/PostgreSQL)

### À qui s'adresse ceci

Ce projet s'adresse à **toute personne qui** :

- **Souhaite apprendre**.
- **Cherche** de l'**inspiration** pour constituer sa propre architecture.
- **Souhaite démarrer le développement d'un site Web** complet et polyvalent.
- S'est perdue ici (_Bienvenue !_).

## Objectifs

Le **but premier** est de **partager** publiquement ce que je fais habituellement dans mon coin **pour permettre à d'autres** de **s'inspirer** voire de **se motiver** à faire leurs propres créations.

Ce repository **peut servir de base** pour **n'importe quel projet de site Web**. En espérant que sa composition corresponde à ce qui vous sera nécessaire pour votre cas particulier.
**Si vous n'avez aucune exigence**, j'ose penser que **vous disposez ici de tout ce qui est nécessaire** pour développer votre propre solution.

Je vous invite donc à **forker ce projet** ou **en faire ce que bon vous semble** à partir du moment où cela peut **vous aider/inspirer/faire apprendre** quelque chose.

### Parcours de développement

**Si vous hésitez à vous lancer**, j'ai longtemps été dans la même situation que vous et **je comprends**. Par conséquent, **je vous invite à lire le [parcours de développement](DEV_JOURNEY.md)** que j'ai rédigé à propos de ce projet.

Si cela peut vous **aider à vous sentir moins seul voire à vous motiver**, j'en serais ravi.

## Outils utilisés

Les outils qui furent utilisés ici sont :

- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) (_développement du backend_)
- [VSCodium](https://vscodium.com/) (_versioning des fichiers ailleurs que dans le projet IntelliJ_)
- [HTTPie](https://httpie.io/) (_requêtes HTTP et tests de l'API_)

## Tutoriels utilisés

Pour leur implémentation, je me suis notamment servi des tutoriels suivants que **je vous invite à consulter en complément d'informations** :

- [Spring Web - API RESTful (HATEOAS)](https://spring.io/guides/tutorials/rest) (_documentation officielle de Spring_)
- [Spring Boot 3 KeyCloak OAuth2](https://www.youtube.com/watch?v=_0oXZKr97ro&list=PLSVW22jAG8pAXU0th247M7xPCekzeNdrH&index=10) (_vidéo YouTube_)
- [Repository Spring Security OAuth2 Keycloak Demo](https://github.com/SaiUpadhyayula/spring-security-oauth2-keycloak-demo) (_repository issu de la vidéo ci-dessus_)
- [Blog OAuth - Basic SPA - Overview](https://github.com/gary-archer/oauth.blog/blob/master/public/posts/basicspa-overview.mdx)
- [Tutoriel Vue version 3](https://vuejs.org/tutorial/#step-1)
- [Keycloak JavaScript adapter](https://www.keycloak.org/securing-apps/javascript-adapter)
- [Spring Boot Keycloak role based authorization with JWT](https://medium.com/@kspoyraz7/spring-boot-keycloak-role-based-authorization-with-jwt-3bd29bdd9016)

## Feuille de route pour la prise en main

### Connaissances préalables conseillées

Pour prendre ce projet en main, je vous invite tout d'abord à disposer des **connaissances nécessaires** afin de **comprendre au mieux** les **concepts abordés ici**.

Je dirais donc que les concepts principaux à connaître sont :

- La [**virtualisation par conteneur**](https://fr.wikipedia.org/wiki/Conteneur_(virtualisation)) avec, dans ce cas-ci, **[Podman](https://fr.wikipedia.org/wiki/Podman)**.
- Ce qu'est une **[API](https://fr.wikipedia.org/wiki/Interface_de_programmation)**
  - Dans ce cas-ci, une **[RPC](https://fr.wikipedia.org/wiki/Appel_de_proc%C3%A9dure_%C3%A0_distance)** mais **[REST](https://fr.wikipedia.org/wiki/Representational_state_transfer)** reste tout aussi intéressant.
- Ce qu'est une **[base de données relationnelle](https://fr.wikipedia.org/wiki/Base_de_donn%C3%A9es_relationnelle)** et ce qu'est **[PostgreSQL](https://fr.wikipedia.org/wiki/PostgreSQL)**.
- La différence entre **[backend](https://fr.wikipedia.org/wiki/Backend) et [frontend](https://fr.wikipedia.org/wiki/Frontal_(informatique))**.
- Ce qu'est un **[Single Sign-On (SSO)](https://fr.wikipedia.org/wiki/Authentification_unique)** et **l'intérêt d'en utiliser un**.
- Ce qu'est un **[Framework](https://fr.wikipedia.org/wiki/Framework)**. Dans notre cas il s'agit de :
  - **[Spring](https://fr.wikipedia.org/wiki/Spring_(framework))** (_backend_)
  - **[Vue.js](https://fr.wikipedia.org/wiki/Vue.js)** (_frontend_)
- **Les différents langages utilisés** ici que sont :
  - [HTML](https://fr.wikipedia.org/wiki/Hypertext_Markup_Language)
  - [Java](https://fr.wikipedia.org/wiki/Java_(langage))
  - [JavaScript](https://fr.wikipedia.org/wiki/JavaScript)
- Les connaissances suivantes ne sont pas abordées ici mais peuvent vous aider à **compléter la compréhension** :
  - Le [langage CSS](https://fr.wikipedia.org/wiki/Feuilles_de_style_en_cascade)
  - Le [langage SQL](https://fr.wikipedia.org/wiki/Structured_Query_Language)

### Étapes à suivre

Une fois que vous vous sentez prêts à plonger dans ce repository, je vous propose de le faire dans cet ordre :

1. La [**base de données**](./database/). Elle se contente ici d'être **un script Podman** à exécuter pour qu'elle s'instancie.
2. Le [**SSO**](./sso/). Il ne s'agit principalement que d'**un script Podman** également mais comporte **plusieurs concepts spécifiques**.
3. Le [**backend**](./backend/). Une **application** Java Spring **reposant sur les deux premiers** pour fonctionner.
4. Le [**frontend**](./frontend/). C'est la **façade** de votre architecture **qui se greffe par dessus le reste**.
