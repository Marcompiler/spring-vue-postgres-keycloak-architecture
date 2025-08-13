# Backend - App

## Description

Nous voici dans **le coeur de l'architecture : l'API**. Elle est au centre de tous les autres éléments de la chaîne : la base de données, le SSO et le frontend.

Il s'agit donc d'une application en [Java](https://www.java.com/fr/), sous le framework [Spring](https://spring.io/) et ~~qui se veut RESTful~~ qui est une API RPC tel que j'ai été corrigé par la lecture de [la documentation officielle de Spring](https://spring.io/guides/tutorials/rest).

## Comment utiliser

Avant toute chose, **veillez à avoir démarré la base de données ainsi que le SSO**. En effet, le backend nécessite ceux-ci pour démarrer correctement.

Ensuite, **plusieurs possibilités** s'offre à vous quant à l'**exécution** et le **développement** de cette partie. Pour ma part, j'utilise généralement [IntelliJ IDEA](https://www.jetbrains.com/idea/) (*Community Edition*).

Sinon, vous pouvez directement exécuter l'application en l'état à l'aide des commandes [Maven](https://maven.apache.org/).

### Exécution à l'aide de Maven

Vous pouvez utiliser "`mvnw`" ici présent afin de vous assurer d'utiliser la version de Maven utilisée durant le développement de cette application. Néanmoins, rien ne vous empêche d'installer Maven sur votre machine et l'utiliser directement. Auquel cas, vous utiliserez non pas `mvnw` mais `mvn` dans les commandes qui suivent.

1. Tout d'abord, **ouvrez votre invite de commande dans ce répertoire**. 
2. Ensuite, **construisez et installez le projet** :

        ./mvnw clean install

1. Enfin, **démarrez le projet** :

        ./mvnw spring-boot:run

2. Faites un appel sur l'un des endpoints du backend avec votre navigateur, [HTTPie](../httpie/) ou, si vous avec `curl` :

        curl http://localhost:8080/api/public

3. Vérifiez que la requête précédente vous renvoie bien : "Hello public". Le backend est alors correctement déployé et exécuté.

### Développement

Pour développer l'application, **veuillez utiliser un IDE** tel que [IntelliJ IDEA](https://www.jetbrains.com/idea/), [VSCodium](https://vscodium.com/) (*dans ce cas, avec les extensions Java correspondante*) ou n'importe quel autre avec lequel vous vous sentez le plus à l'aise **tant qu'il supporte le langage Java**.

La plupart des fichiers ici ont été générés par [Spring Initializr](https://start.spring.io), vous n'avez donc pas à vous en soucier pour le bon fonctionnement de l'application.

**Pour entamer votre développement/compréhension**, vous pouvez **directement plonger** dans le répertoire [**`main`**](./src/main/).
