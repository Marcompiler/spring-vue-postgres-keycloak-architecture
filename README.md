# Architecture Web - Exemple Spring-Vue-Postgres-Keycloak

## Description

Ce repository est une **architecture permettant de développer un site Web complet** avec tous les éléments nécessaires : un **backend**, un **frontend**, une **base de données** et une **authentification unique**.

Le tout **uniquement avec des éléments/outils open source** (_en tous cas autant que possible_).

## À qui s'adresse ceci

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

## Architecture

### Structure de l'architecture

L'architecture est donc constituée de la façon suivante :

- [Un backend API REST](./backend/)
  - [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
  - [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/index.html)
  - [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
- [Un frontend](./frontend/)
  - [Vue.JS](https://vuejs.org/)
- [Une authentification unique (SSO)](./sso/)
  - [Keycloak](https://www.keycloak.org/)
- [Une base de données](./database/)
  - [PostgreSQL](https://fr.wikipedia.org/wiki/PostgreSQL)

### Fonctionnement de l'architecture

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="./images/fullstack%20diagram.dark-theme.svg">
  <source media="(prefers-color-scheme: light)" srcset="./images/fullstack%20diagram.white-theme.svg">
  <img alt="Architecture diagram" src="./images/fullstack%20diagram.png">
</picture>

Donc, voici comment ça se présente. Ce schéma permet de visualiser aisément les interactions entre les différents éléments de l'architecture.

Ce diagramme part du principe que les utilisateurs ont tous un compte préexistant au sein du SSO et que l'utilisateur tente d'accéder à une ressource "protégées" (_nécessitant authentification_).

À partir du moment où un utilisateur va tenter d'accéder au site Web, une suite d'étapes va s'enclencher pour lui donner le résultat attendu (_code couleur repris du diagramme, non visible sur GitHub_) :

1. Tout d'abord, **l'utilisateur accède au <span style="color:red">frontend</span>** en allant sur l'URL de celui-ci.
2. **Si l'utilisateur n'est pas authentifié**, il est directement **redirigé vers le <span style="color:violet">SSO</span>**. L'utilisateur va alors devoir **saisir ses identifiants** pour être **authentifié auprès du <span style="color:violet">SSO</span> et aux yeux du <span style="color:red">frontend</span>**.
3. **Une fois authentifié**, l'utilisateur est **redirigé vers la page initiale du <span style="color:red">frontend</span>** qu'il tentait d'accéder. Le **<span style="color:red">frontend</span> va alors charger** le contenu de la page.
4. **Pour charger le contenu**, le **<span style="color:red">frontend</span> peut devoir faire appel au <span style="color:lightgreen">backend</span>**. Cet appel comporte alors un Json Web Token (_JWT_) contenant l'identité de l'utilisateur ayant fait la requête initiale.
5. **Pour vérifier l'identité et les autorisations** de l'utilisateur, **le <span style="color:lightgreen">backend</span> contacte alors le <span style="color:violet">SSO</span> avec le JWT** reçu pour lui demander si celui-ci est valide.
6. **Si le <span style="color:violet">SSO</span> répond positivement**, cela donne alors le **feu vert au <span style="color:lightgreen">backend</span> pour répondre à la requête du <span style="color:red">frontend</span>** faite à l'étape 4.
7. Pour répondre, **le <span style="color:lightgreen">backend</span> va** souvent **interagir avec la <span style="color:cyan">base de données</span>** pour traiter les données demandées par la requête.
8. **Le <span style="color:lightgreen">backend</span> répond enfin à la requête avec le contenu demandé** qui va venir **compléter celui du <span style="color:red">frontend</span>**.
9. Une fois le contenu chargé, le **<span style="color:red">frontend</span> renvoie le résultat final** à l'utilisateur.

## Pour démarrer

### Prérequis

Avant de commencer, assurez-vous d’avoir installé :

- **[Podman](https://podman.io/docs/installation)** (_ou [Docker](https://docs.docker.com/get-started/get-docker/)_) pour lancer la base de données et le SSO (_voire le backend et le frontend_).
  - **[Podman-Compose](https://podman-desktop.io/docs/compose/setting-up-compose)** (_ou [Docker-Compose](https://docs.docker.com/compose/install/)_) est également conseillé. Sinon vous devrez convertir les `.yml` en commandes `run`.
- **[Java 24+](https://jdk.java.net/24/)** pour le backend Spring.
- **[Maven](https://maven.apache.org/download.cgi)** pour construire le backend.
- **[Node.js 22+](https://nodejs.org/fr/download)** et **[npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)** pour le frontend.

Si ce n'est déjà fait, je vous invite à **redémarrer votre machine** une fois la/les installations terminées.

### Variables d'environnement

La base de données et l'authentification unique (_SSO_) dépendent d'un fichier de variables d'environnement pour démarrer. Veillez donc à créer une copie du fichier `.env.*.template` et le renommer en retirant `.template`.

Cela donne donc :

| Élément | Fichier template | Nom de la copie |
| --- | --- | --- |
| Base de données | [`.env.database.template`](./database/podman/.env.database.template) | `.env.database` |
| SSO | [`.env.sso.template`](./sso/podman/dev/.env.sso.template) | `.env.sso` |

Attention que si vous modifiez les valeurs, il faut répercuter ces modifications dans les configurations qui les utilisent :

- Les valeurs de `.env.database` sont utilisées par le backend dans son [application.properties](./backend/app/src/main/resources/application.properties) et ses scripts d'exécution Podman (_[Linux](./backend/app/podman-run.sh)/[Windows](./backend/app/podman-run.ps1)_).
- Les valeurs de `.env.sso` sont à utiliser lors de la connexion à l'interface Web du SSO en tant qu'administrateur (adresse par défaut : <http://localhost:8080>).

Une fois les copies créées et renommées, **vous pouvez alors démarrer tous** les éléments de l'architecture **par Podman et/ou par commandes** selon ce qui vous accommode le mieux.

### Scripts Podman (_ou Docker_)

**Chaque élément** de l'architecture **comporte des scripts** pour démarrer au sein d'un conteneur. Par conséquent, vous trouverez des **scripts `.sh` pour Linux et `.ps1` pour Windows**.

Vous pouvez donc exécuter les scripts **dans cet ordre, dans leur répertoire respectif** selon votre environnement :

| Ordre | Élément à démarrer | Linux | Windows |
| --- | --- | --- | --- |
| 1 | **Base de données** | [Run](./database/podman/podman-run.sh) | [Run](./database/podman/podman-run.ps1) |
| 2 | **SSO** (_DEV_) | [Run](./sso/podman/dev/podman-run.sh) | [Run](./sso/podman/dev/podman-run.ps1) |
| 3 | **Backend** | [Build](./backend/app/podman-build.sh) -> [Run](./backend/app/podman-run.sh) | [Build](./backend/app/podman-build.ps1) -> [Run](./backend/app/podman-run.ps1) |
| 4 | **Frontend** | [Build](./frontend/app/podman-build.sh) -> [Run](./frontend/app/podman-run.sh) | [Build](./frontend/app/podman-build.ps1) -> [Run](./frontend/app/podman-run.ps1) |

Certains ont "`Build -> Run`", cela signifie que vous devez **d'abord construire l'image** à instancier pour le conteneur. Il suffit donc d'exécuter **`Build` puis `Run`**.

_N.B. : **Pour Docker**, il suffit de **remplacer** toutes les occurrences de **"podman" par "docker"**._

### Commandes à exécuter

**_Veillez à respecter l'ordre d'exécution_**.

Avant toute chose, certains éléments de l'architecture nécessite Podman/Docker, assurez-vous donc que la machine correspondante existe et est démarrée :

```sh
podman machine init
podman machine start
```

Chaque élément de l'architecture comporte un script pour le démarrer :

#### Base de données (1/4)

Exécutez la commande suivante pour **démarrer un conteneur Postgres** :

```sh
podman-compose -f "./database/podman/podman-compose.yml" up -d
```

#### Authentification unique (SSO) (2/4)

Exécutez la commande suivante pour **démarrer un conteneur Keycloak** (_pour le développement_) :

```sh
podman-compose -f "./sso/podman/dev/podman-compose.yml" up -d
```

#### Backend (3/4)

Allez dans le **répertoire de l'application backend** :

```sh
cd backend/app
```

**Démarrez l'application** au moyen des commandes suivantes :

```sh
./mvnw clean install
./mvnw spring-boot:run
```

#### Frontend (4/4)

Allez dans le **répertoire de l'application frontend** :

```sh
cd frontend/app
```

**Démarrez l'application** au moyen des commandes suivantes :

```sh
npm install
npm run dev
```

**L'ensemble des éléments est alors démarré** et vous pouvez commencer à **tester votre site Web** en allant sur <http://localhost:5173>.

### Parcours de développement

**Si vous hésitez à vous lancer**, j'ai longtemps été dans la même situation que vous et **je comprends**. Par conséquent, **je vous invite à lire le [parcours de développement](DEV_JOURNEY.md)** que j'ai rédigé à propos de ce projet.

Si cela peut vous **aider à vous sentir moins seul voire à vous motiver**, j'en serais ravi.

## Feuille de route pour la prise en main

### Connaissances préalables conseillées

Pour prendre ce projet en main, je vous invite tout d'abord à disposer des **connaissances nécessaires** afin de **comprendre au mieux** les **concepts abordés ici**.

Je dirais donc que les concepts principaux à connaître sont :

- La [**virtualisation par conteneur**](https://fr.wikipedia.org/wiki/Conteneur_(virtualisation)) avec, dans ce cas-ci, **[Podman](https://fr.wikipedia.org/wiki/Podman)**.
- Ce qu'est une **[API](https://fr.wikipedia.org/wiki/Interface_de_programmation)**
  - Dans ce cas-ci, une API **[REST](https://fr.wikipedia.org/wiki/Representational_state_transfer)**. Tenir compte qu'elle n'est qu'au [**niveau 2** du modèle de maturité de Richardson](https://fr.wikipedia.org/wiki/Mod%C3%A8le_de_maturit%C3%A9_de_Richardson#Niveau_2_:_verbes_HTTP).
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

## Tutoriels utilisés

Pour leur implémentation, je me suis notamment servi des tutoriels suivants que **je vous invite à consulter en complément d'informations** :

- [Spring Web - API RESTful (HATEOAS)](https://spring.io/guides/tutorials/rest) (_documentation officielle de Spring_)
- [Spring Boot 3 KeyCloak OAuth2](https://www.youtube.com/watch?v=_0oXZKr97ro&list=PLSVW22jAG8pAXU0th247M7xPCekzeNdrH&index=10) (_vidéo YouTube_)
- [Repository Spring Security OAuth2 Keycloak Demo](https://github.com/SaiUpadhyayula/spring-security-oauth2-keycloak-demo) (_repository issu de la vidéo ci-dessus_)
- [Blog OAuth - Basic SPA - Overview](https://github.com/gary-archer/oauth.blog/blob/master/public/posts/basicspa-overview.mdx)
- [Tutoriel Vue version 3](https://vuejs.org/tutorial/#step-1)
- [Keycloak JavaScript adapter](https://www.keycloak.org/securing-apps/javascript-adapter)
- [Spring Boot Keycloak role based authorization with JWT](https://medium.com/@kspoyraz7/spring-boot-keycloak-role-based-authorization-with-jwt-3bd29bdd9016)
- [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker)
- [Dockerize Vue.js App](https://v2.vuejs.org/v2/cookbook/dockerize-vuejs-app.html?redirect=true)

## Outils utilisés

### Pour le développement

- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) (_développement du backend_)
- [VSCodium](https://vscodium.com/) (_développement du reste de l'architecture_)
- [HTTPie](https://httpie.io/) (_requêtes HTTP et tests de l'API_)

### Pour les images

- [draw.io](https://www.drawio.com/) (_constitution des diagrammes_)
- [GIMP](https://www.gimp.org/) (_découpage des logos, assemblage, etc._)

### Annexes

- [LibreTranslate](https://libretranslate.com/) (_traductions_)
- [DeepL](https://www.deepl.com) (_traductions_)
- [ChatGPT](https://chatgpt.com) (_le mouton noir, il m'a aidé à comprendre les concepts et à trouver certaines syntaxes dans le code_)
