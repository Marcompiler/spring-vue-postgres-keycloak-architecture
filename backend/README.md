# Backend

## Description

L'idée ici va être de développer une application Java en utilisant le framework Spring.

Cette application aura pour but d'être une **API RPC**.
Celle-ci permettra également d'interagir avec une base de données PostgreSQL au travers de Spring JPA qui va gérer les entités et les migrations.

### Pourquoi pas REST ?

**De base, c'était l'idée**.

**Néanmoins**, je me suis rendu compte **je m'étais trompé** au niveau des concepts **RPC/REST** à la lecture de [la documentation Spring](https://spring.io/guides/tutorials/rest).

Par conséquent, **pour garder les explications "accessibles" et le code "léger"**, j'ai décidé de rester au stade d'une **API RPC**.

Ainsi, **si vous le souhaitez**, je vous invite à vous baser sur **[cette même documentation](https://spring.io/guides/tutorials/rest)** s'ils en ont **le besoin/l'envie de développer une API RESTful ou**, comme moi, **simplement comprendre** réellement ce dont il s'agit. De ce que j'ai vu, ça semble plutôt simple à changer au niveau du code grâce à leur HATEOAS et ils l'expliquent bien mieux que moi.

## Comment utiliser

### Création du projet

Tout d'abord, il a fallu **créer le projet**, j'ai donc utilisé la **[configuration suivante](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.5.4&packaging=jar&jvmVersion=24&groupId=com.yourdomain&artifactId=backend&name=backend&description=Backend%20of%20the%20stack.&packageName=com.yourdomain.backend&dependencies=web,devtools,validation,data-jpa,configuration-processor,oauth2-resource-server,postgresql,security)** avec [Spring Initializr](https://start.spring.io).

### Démarrage le projet

Ensuite, **veillez d'abord** à avoir **démarré** la **base de données** et le **SSO** pour que le backend puisse fonctionner.

**Ouvrez** alors le projet **dans IntelliJ IDEA** et **démarrez** le projet.
