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

- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) (*développement de l'application*)
- [VSCodium](https://vscodium.com/) (*versioning des fichiers ailleurs que dans le projet IntelliJ*)
- [HTTPie](https://httpie.io/) (*requêtes HTTP et tests de l'API*)

## Tutoriels utilisés

Pour leur implémentation, je me suis servi des tutoriels suivants :

- [Spring Web - API RESTful (HATEOAS)](https://spring.io/guides/tutorials/rest) (*documentation officielle de Spring*)
- [Spring Boot 3 KeyCloak OAuth2](https://www.youtube.com/watch?v=_0oXZKr97ro&list=PLSVW22jAG8pAXU0th247M7xPCekzeNdrH&index=10) (*vidéo YouTube*)
- [Repository Spring Security OAuth2 Keycloak Demo](https://github.com/SaiUpadhyayula/spring-security-oauth2-keycloak-demo) (*repository issu de la vidéo ci-dessus*)
- [Blog OAuth - Basic SPA - Overview](https://github.com/gary-archer/oauth.blog/blob/master/public/posts/basicspa-overview.mdx)

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
