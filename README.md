# Test-Architecture-Spring_Keycloak_VueJS

Ce repository a pour but de **tester** l'ensemble des **fonctionnalités de base** issues **de l'architecture** 
que je souhaite tester ici.

## Architecture

L'architecture est donc constituée de la façon suivante :

- [Un backend API RESTful](./backend/README.md)
  - [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
  - [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/index.html)
  - [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
- [Un frontend](./frontend/README.md)
  - [Vue.JS](https://vuejs.org/)
- [Un serveur d'autorisation (SSO)](./authorization-server/README.md)
  - [Keycloak](https://www.keycloak.org/)

## Outils utilisés

Les outils qui furent utilisés ici sont :

- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) (_développement de l'application_)
- [VSCodium](https://vscodium.com/) (_versioning des fichiers ailleurs que dans le projet IntelliJ_)
- [HTTPie](https://httpie.io/) (_requêtes HTTP et tests de l'API_)

## Tutoriels utilisés

Pour leur implémentation, je me suis notamment servi des tutoriels suivants :

- [Spring Web - API RESTful (HATEOAS)](https://spring.io/guides/tutorials/rest) (_documentation officielle de Spring_)
- [Spring Boot 3 KeyCloak OAuth2](https://www.youtube.com/watch?v=_0oXZKr97ro&list=PLSVW22jAG8pAXU0th247M7xPCekzeNdrH&index=10) (_vidéo YouTube_)
- [Repository Spring Security OAuth2 Keycloak Demo](https://github.com/SaiUpadhyayula/spring-security-oauth2-keycloak-demo) (_repository issu de la vidéo ci-dessus_)
- [Blog OAuth - Basic SPA - Overview](https://github.com/gary-archer/oauth.blog/blob/master/public/posts/basicspa-overview.mdx)
- [Tutoriel Vue version 3](https://vuejs.org/tutorial/#step-1)
- [Keycloak JavaScript adapter](https://www.keycloak.org/securing-apps/javascript-adapter)
- [Spring Boot Keycloak role based authorization with JWT](https://medium.com/@kspoyraz7/spring-boot-keycloak-role-based-authorization-with-jwt-3bd29bdd9016)

## Parcours de développement

J'ai pensé que **partager mon parcours** sur la **prise en main** de ces technologies
et des **difficultés** que j'ai rencontrées pourraient potentiellement **inspirer voire motiver d'autres à se lancer**.
Le voici donc.

J'ai commencé par me faire des **piqûres de rappel** quant à mes cours sur Java Spring et à faire
plusieurs brouillons de schémas de base de données. J'ai entamé **plusieurs projets que j'ai abandonnés**
car **je me sentais bloqué** par mon **manque de connaissances**, générant chez moi un **sentiment d'illégitimé**
qui me dissuadait alors de continuer.

Ensuite, j'ai **accumulé les connaissances nécessaires**, notamment aux moyens des tutoriels susmentionnés,
**pour comprendre exactement ce que j'allais utiliser et pourquoi**. 
J'ai dû **accepter de ne pas pouvoir tout bien faire dès le départ**, ce qui, encore à ce jour, reste compliqué.

Après plusieurs tâtonnements, des dérapages, voire des décrochages, j'ai fini par constituer **petit à petit**
une **base fonctionnelle entre la base de données, le backend et le SSO**. Cela m'a aidé à **reprendre confiance en moi**
ainsi qu'**en ma stack de développement** qui, elle aussi, fut un calvaire à constituer
afin d'**allier confort et valeurs personnelles**.

Une fois que j'ai pu **comprendre** vraiment l'**Authorization Code Flow**, j'ai pu commencer à réfléchir sur
comment entreprendre la partie frontend.

J'ai alors réussi à **créer mon application VueJS** (*Vue 3*) avec `npm` puis ai décidé de **suivre le tutoriel lié**
au framework. **Une fois que j'ai eu les bases** de Vue, j'ai essayé de trouver comment **implémenter Keycloak** 
dans l'application.

Une fois que j'y suis parvenu, ça m'a d'autant plus **motivé à continuer** : je parvenais désormais à faire 
**communiquer mon SSO autant avec mon API qu'avec mon frontend**. Je savais alors que je n'avais plus qu'à faire communiquer 
le frontend avec l'API et, là, toutes les pièces du puzzle de base seraient enfin assemblées.

Dès le lendemain, je m'y suis remis, **ai appris** comment faire des requêtes avec `fetch` en JavaScript, 
gérer le CORS dans l'API puis ai appelé les différents endpoints de l'API, **tout fonctionnait**. 
Ce fut un vrai relâchement car je sus alors que **la stack que j'avais constituée était fonctionnelle**.

Ensuite, étant **spécialisé backend** initialement, j'ai recherché un **framework CSS avec composants**,
cela afin de comparer les alternatives au lieu d'[Element Plus](https://element-plus.org), juste pour voir. 
J'ai alors découvert [PrimeVue](https://primevue.org/) qui, malgré un nombre d'étoiles moins important que d'autres,
m'a semblé fiable, complet et clairement documenté.

**Néanmoins**, j'ai tenu à ce que **ce projet se limite au nécessaire** tout en **laissant le choix** sur les technologies qui
vont **au-delà de la portée prévue** par ce projet. Je me suis donc finalement contenté de mentionner 
les deux frameworks CSS ci-dessus afin de vous laisser choisir, parmi eux ou d'autres encore, ce que vous préférez.

Enfin, **le clou final** à ce projet m'a paru être ce qui allait être de toute façon nécessaire pour la suite : 
**la gestion des utilisateurs au niveau du backend-database**. En effet, on ne se limite généralement pas au SSO pour nos
utilisateurs ; celui-ci se contente d'authentifier et de sécuriser les données nécessaires à cette authentification.

**Pour les données propres à l'application**, liées aux mêmes utilisateurs, il faut donc les gérer au sein de celle-ci.
Sans parler que je n'ai pas encore essayé d'**interpréter les rôles définis par le SSO dans le backend**.
C'est alors devenu mon **prochain objectif**.

Durant un week-end hors de chez moi, j'ai profité d'un instant sur mon portable pour investiguer sur comment
**implémenter les rôles** au niveau de mon architecture. J'ai alors découvert les différents types de rôles dans Keycloak.
Il y a alors **deux types de rôles** :

- Les rôles au niveau des **Realms**.
- Les rôles au niveau des **clients**.

Une fois que j'ai pu **comprendre** la différence entre les deux, j'ai pu les retrouver au sein de mon API Spring.
Ayant déjà dû gérer des claims SSO au sein de mon travail, j'ai rapidement compris comment étaient transportés
les rôles au sein des JWT.

Ensuite, **en usant d'un tutoriel** (*qui, je dois dire, comportait quelques incohérences, notamment entre l'article et
le repository associé*) **combiné à l'aide de l'IA**, j'ai fini par constituer une **architecture** 
qui m'a paru **suffisamment solide et modulaire**.

À ce stade, je suis pratiquement certain qu'il ne me reste **plus qu'une seule étape** : **gérer les claims SSO**.
Ce notamment pour récupérer les identifiants utilisateurs afin de pouvoir leur associer des données spécifiques au 
niveau de l'API Spring dans la base de données Postgres dédiée.
Il faut donc également constituer une **base pour la structure de données des utilisateurs** pour donner forme à cela.

Et... voilà. Ce fut le dernier stade (*étonnement facile comparé au reste*) que j'ai pu imaginer jusqu'ici et
qui me semblait être essentiel pour débuter pleinement un projet.
En effet, on dispose désormais :

- d'une base de données fiable, solide et polyvalente.
- d'un backend se connectant à la base de données et générant son contenu automatiquement.
- d'un frontend se connectant au backend pour interagir avec les données au travers du portail sécurisé que représente le backend.
- d'un single-sign on (*SSO*) permettant d'authentifier voire gérer les autorisations des utilisateurs.

Le tout interagissant les uns avec les autres de manière fonctionnel tout en étant constitué que d'éléments open source
avec chacun une réputation solide et une grande polyvalence.

La cerise sur le gâteau avant de partager tout cela est de documenter le tout au mieux afin que 
quiconque souhaitant se lancer puisse disposer d'informations claires et d'une base (*au moins de réflexion*) solide 
pour concrétiser ses idées.
