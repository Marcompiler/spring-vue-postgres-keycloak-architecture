# Backend

## Description

L'idée ici va être de développer une **application [Java](https://fr.wikipedia.org/wiki/Java_(langage))** en utilisant le **framework [Spring](https://fr.wikipedia.org/wiki/Spring_(framework))**.

Cette application aura pour but d'être une [**API REST** de niveau 2](https://fr.wikipedia.org/wiki/Mod%C3%A8le_de_maturit%C3%A9_de_Richardson#Niveau_2_:_verbes_HTTP).
Celle-ci permettra également d'interagir avec une base de données PostgreSQL au travers de Spring JPA qui va gérer les entités et les migrations.

### Pourquoi pas RESTful ?

**De base, c'était l'idée**.

**Néanmoins**, je me suis rendu compte **je m'étais trompé** au niveau des concepts **RPC/REST/RESTful** à la lecture de [la documentation Spring](https://spring.io/guides/tutorials/rest) puis à la découverte du [modèle de Richardson](https://fr.wikipedia.org/wiki/Mod%C3%A8le_de_maturit%C3%A9_de_Richardson).

Par conséquent, **pour garder les explications "accessibles" et le code "léger"**, j'ai décidé de rester au stade d'une **[API REST de niveau 2](https://fr.wikipedia.org/wiki/Mod%C3%A8le_de_maturit%C3%A9_de_Richardson#Niveau_2_:_verbes_HTTP)**.

Ainsi, **si vous le souhaitez**, je vous invite à vous baser sur **[cette même documentation](https://spring.io/guides/tutorials/rest)** si vous avez **le besoin/l'envie de développer une API RESTful ou**, comme moi, **simplement comprendre** réellement ce dont il s'agit. De ce que j'ai vu, ça semble plutôt simple à changer au niveau du code grâce à leur HATEOAS et ils l'expliquent bien mieux que moi.

## Comment utiliser

### Création du projet

Tout d'abord, il a fallu **créer le projet**, j'ai donc utilisé la **[configuration suivante](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.5.4&packaging=jar&jvmVersion=24&groupId=com.yourdomain&artifactId=backend&name=backend&description=Backend%20of%20the%20stack.&packageName=com.yourdomain.backend&dependencies=web,devtools,validation,data-jpa,configuration-processor,oauth2-resource-server,postgresql,security)** avec [Spring Initializr](https://start.spring.io).

### Démarrage le projet

Ensuite, **veillez d'abord** à avoir **démarré** la **base de données** et le **SSO** pour que le backend puisse fonctionner.

**Ouvrez** alors le projet **dans IntelliJ IDEA** et **démarrez** le projet.
