# Backend - App - Main - Java - HelloWorld

## Description

Le classique **["Hello world"](https://fr.wikipedia.org/wiki/Hello_world)**.
*Il fallait évidemment qu'il soit présent dans un projet de prise en main tel que celui-ci*.

Ce répertoire permet de **rapidement prendre en main les différents concepts** fréquemment manipulés au sein d'une API où chacun a un rôle qui lui est propre :

- Les **entités avec [`HelloWorld.java`](./HelloWorld.java)**. Elles représentent les **structures de données**.
- Les **controllers avec [`HelloWorldController.java`](./HelloWorldController.java)**. Ils permettent de faire le **pont de manière contrôlée entre les actions sur les données** de la base de données **et l'extérieur**.
- Les **repositories avec [`HelloWorldRepository.java`](./HelloWorldRepository.java)**. C'est par eux que l'API doit passer pour **interagir directement avec la base de données**. Les **controllers** se contentant de faire le **contrôle** pour permettre l'action, ce sont bien les **repositories** qui font l'**action** en tant que telle.
- Un **initialiseur de données [`HelloWorldDataInitializer.java`](./HelloWorldDataInitializer.java)**. On en utilise **généralement pour le premier démarrage** de l'application avec que celle-ci puisse être **déployée avec des données** au sein de la base de données, celles **nécessaires** au bon fonctionnement et/ou à l'utilisation de base de l'application par les utilisateurs.

## Comment utiliser

Ici, il s'agit donc d'**observer l'initialisation des données** dont s'occupe l'[initialisateur](./HelloWorldDataInitializer.java) **lors du démarrage de l'API**.

**Une fois l'API démarrée**, il est possible de **manipuler/récupérer les [entités](./HelloWorld.java)** au travers du [controller](./HelloWorldController.java) qui va faire appel au [repository](./HelloWorldRepository.java) pour modifier/récupérer les données sauvegardées.

Pour ce faire, **authentifiez-vous au sein du SSO**, **récupérez le [Json Web Token (*JWT*)](https://fr.wikipedia.org/wiki/JSON_Web_Token)** et **passez-le avec votre requête** vers l'un des endpoints de l'API tels que, dans ce cas-ci :

```sh
http://localhost:8081/api/helloworld
```

Vous obtiendrez alors une **réponse HTTP 200 (OK) : "`Hello world`"**.
Celle-ci vous permet de savoir que **votre API est bien démarrée et est accessible au travers de l'authentification**.
