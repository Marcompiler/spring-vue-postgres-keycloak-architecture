# Backend - App - Main - Java - Config - Security

## Description

**Gros morceau** de la configuration : **la sécurité** de l'application. 

Autrement dit, c'est ici que nous allons configurer ce qui permettra d'**évaluer les accès à l'application** par des intervenants et autres applications.

Il y a donc deux fichiers :

- [`CorsConfig.java`](./CorsConfig.java) : dédié à la gestion du [**Cross Origin Resource Sharing (*CORS*)**](https://developer.mozilla.org/fr/docs/Web/HTTP/Guides/CORS). Définit alors **les [origines](https://developer.mozilla.org/fr/docs/Web/Security/Same-origin_policy#d%C3%A9finition_de_lorigine) pouvant appeler notre application** mais aussi **les [méthodes HTTP](https://developer.mozilla.org/fr/docs/Web/HTTP/Reference/Methods) et les [en-têtes HTTP](https://developer.mozilla.org/fr/docs/Web/HTTP/Reference/Headers) autorisées**.
- [`SecurityConfig.java`](./SecurityConfig.java) : dédié à la **sécurité plus globale** de l'application avec la définition des **endpoints publiques et ceux nécessitant une authentification**. Il définit également comment récupérer les **rôles issus du SSO** lors de l'utilisation du [**Json Web Token (*JWT*)**](https://fr.wikipedia.org/wiki/JSON_Web_Token).

En l'état actuel, on ne permet qu'au frontend (*localhost:5173*) de communiquer avec notre backend dans [`CorsConfig.java`](./CorsConfig.java). De plus, on a définit des endpoints publiques et authentifiés ainsi que la récupération des rôles depuis le JWT d'après la spécificité de notre SSO : Keycloak.

## Comment utiliser

La **configuration par défaut** est **utilisable en l'état**. Néanmoins, vous pouvez l'**ajuster** en fonction de **votre environnement** et **vos besoins/préférences**.

Si vous souhaitez **explorer les possibilités** de configuration, je vous invite à consulter :

- [Cet article](https://howtodoinjava.com/spring-boot2/spring-cors-configuration/) pour le **CORS**.
- [La documentation officielle de Spring](https://docs.spring.io/spring-security/reference/servlet/configuration/java.html) pour la classe **SecurityConfig**.
