# Backend

L'idée ici va être de développer une application Java en utilisant le framework Spring.

## But

Cette application aura pour but d'être une API RESTful suivant les principes de HATEOAS.
Celle-ci permettra également d'interagir avec une base de données PostgreSQL au travers de Spring JPA qui va gérer les entités et les migrations.

## Comment démarrer

### Création du projet

Tout d'abord, il a fallu créer le projet, j'ai donc utilisé la [configuration suivante](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.4.7&packaging=jar&jvmVersion=21&groupId=com.marcompiler&artifactId=test-architecture-rest-jpa-oauth2&name=test-architecture-rest-jpa-oauth2&description=Test%20for%20an%20architecture%20with%20JPA%2C%20OAuth2%20and%20REST%20(with%20Postgres%2C%20Keycloak%20and%20Vue.JS%20in%20mind).&packageName=com.marcompiler.test-architecture-rest-jpa-oauth2&dependencies=web,devtools,hateoas,validation,data-jpa,configuration-processor,oauth2-resource-server,postgresql,security) avec [Spring Initializr](https://start.spring.io).