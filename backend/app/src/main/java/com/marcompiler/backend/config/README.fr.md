# Backend - App - Main - Java - Config

## Description

**La configuration de l'application** ne peut se faire uniquement au travers du [`application.properties`](../../../../../resources/application.properties), il faut en effet passer **en partie par le code de l'application elle-même**.

Ici, il y a donc deux aspects principaux dans cette configuration :

- La **persistance des données**.
- La **sécurité de l'application**.

La **sécurité** a son [**dossier dédié**](./security/) puisqu'il y a plusieurs éléments la concernant. La **persistence**, elle, est configurée à l'aide de cet unique fichier : [**`PersistenceConfig.java`**](./PersistenceConfig.java).

## Comment utiliser

La **configuration par défaut** est évidemment **utilisable en l'état**.

**Sur base de la [documentation officielle de Spring](https://docs.spring.io/spring-data/jpa/docs/current/api/index.html)**, vous pouvez **ajuster/modifier** les annotations et contenu de [**`PersistenceConfig.java`**](./PersistenceConfig.java) afin de correspondre au mieux à votre environnement.
