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

## Tutoriels utilisés

Pour leur implémentation, je me suis servi des tutoriels suivants :

- [Spring Web - API RESTful (HATEOAS)](https://spring.io/guides/tutorials/rest) (*documentation officielle de Spring*)
- [Spring Boot 3 KeyCloak OAuth2](https://www.youtube.com/watch?v=_0oXZKr97ro&list=PLSVW22jAG8pAXU0th247M7xPCekzeNdrH&index=10) (*vidéo YouTube*)
- [Repository Spring Security OAuth2 Keycloak Demo](https://github.com/SaiUpadhyayula/spring-security-oauth2-keycloak-demo) (*repository issu de la vidéo ci-dessus*)
- [Blog OAuth - Basic SPA - Overview](https://github.com/gary-archer/oauth.blog/blob/master/public/posts/basicspa-overview.mdx)
