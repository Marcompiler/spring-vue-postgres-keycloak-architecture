# Test-Architecture-Spring_Keycloak_VueJS

Ce repository a pour but de tester l'ensemble des fonctionnalités de base mises à disposition par l'architecture que je souhaite tester ici.

## Architecture

L'architecture est donc constituée de la façon suivante :

- [Un backend API RESTful](./backend/README.md)
  - [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
  - [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/index.html)
  - [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
- [Un frontend](./frontend/README.md)
  - [Vue.JS](https://vuejs.org/)
  - [Element Plus](https://element-plus.org)
- [Un serveur d'autorisation (SSO)](./authorization-server/README.md)
  - [Keycloak](https://www.keycloak.org/)

## Outils utilisés

Les outils qui furent utilisés ici sont :

- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) (_développement de l'application_)
- [VSCodium](https://vscodium.com/) (_versioning des fichiers ailleurs que dans le projet IntelliJ_)
- [HTTPie](https://httpie.io/) (_requêtes HTTP et tests de l'API_)

## Tutoriels utilisés

Pour leur implémentation, je me suis servi des tutoriels suivants :

- [Spring Web - API RESTful (HATEOAS)](https://spring.io/guides/tutorials/rest) (_documentation officielle de Spring_)
- [Spring Boot 3 KeyCloak OAuth2](https://www.youtube.com/watch?v=_0oXZKr97ro&list=PLSVW22jAG8pAXU0th247M7xPCekzeNdrH&index=10) (_vidéo YouTube_)
- [Repository Spring Security OAuth2 Keycloak Demo](https://github.com/SaiUpadhyayula/spring-security-oauth2-keycloak-demo) (_repository issu de la vidéo ci-dessus_)
- [Blog OAuth - Basic SPA - Overview](https://github.com/gary-archer/oauth.blog/blob/master/public/posts/basicspa-overview.mdx)
- [Tutoriel Vue version 3](https://vuejs.org/tutorial/#step-1)
- [Keycloak JavaScript adapter](https://www.keycloak.org/securing-apps/javascript-adapter)

## Parcours de développement

J'ai pensé que partager mon parcours sur la prise en main de ces technologies
et des difficultés que j'ai rencontrées pourraient potentiellement inspirer voire motiver d'autres à se lancer.
Le voici donc.

J'ai commencé par me faire des piqûres de rappel quant à mes cours sur Java Spring et à faire
plusieurs brouillons de schémas de base de données. J'ai entamé des projets que j'ai fréquemment abandonnés
car je me sentais bloqué par mon manque de connaissances, générant chez moi un sentiment d'incompétence
qui me dissuadait alors de continuer.

Ensuite, j'ai accumulé les connaissances nécessaires, notamment aux moyens des tutoriels susmentionnés,
pour comprendre exactement ce que j'allais utiliser et pourquoi. J'ai dû accepter
de ne pas pouvoir tout bien faire dès le départ, ce qui, encore à ce jour, reste compliqué.

Après plusieurs tâtonnements, des dérapages, voire des décrochages, j'ai fini par constituer petit à petit
une base fonctionnelle entre la base de données, le backend et le SSO. Cela m'a aidé à reprendre confiance en moi
ainsi qu'en ma stack de développement qui, elle aussi, fut un calvaire à constituer
afin d'allier confort et valeurs personnelles.

Une fois que j'ai pu comprendre vraiment l'Authorization Code Flow, j'ai pu commencer à réfléchir sur
comment entreprendre la partie frontend.

J'ai alors réussi à créer mon application VueJS (_Vue 3_) avec `npm` puis ai décidé de suivre le tutoriel lié
au framework. Une fois que j'ai eu les bases de Vue, j'ai essayé de trouver comment implémenter Keycloak dans l'application.

Une fois que j'y suis parvenu, ça m'a d'autant plus motivé à continuer : je parvenais désormais à faire communiquer mon SSO
autant avec mon API qu'avec mon frontend. Je savais alors que je n'avais plus qu'à faire communiquer le frontend avec l'API
et, là, toutes les pièces du puzzle de base seraient enfin assemblées.
