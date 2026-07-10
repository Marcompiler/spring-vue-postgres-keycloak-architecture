# Backend - App - Migrations de base de données

## Description

Ici se trouve l'ensemble des scripts de migration de la base de données.

On utilise ici [Flyway](https://fr.wikipedia.org/wiki/Flyway_(logiciel)) pour gérer ces migrations.
L'application backend va alors, à chaque démarrage, interroger la base de données pour vérifier
en quelle version elle est par rapport aux scripts présents ici.

Selon la réponse, **le backend va alors exécuter** ces scripts, **dans l'ordre**, jusqu'à ce que la base de données 
soit à la même version que celles des scripts.

Par exemple, si vous avez trois scripts, respectivement préfixé par "V001", "V002","V003", le backend va les exécuter
dans cet ordre dans la base de données.

## Comment utiliser

Si vous devez ajuster votre structure de données, vous devrez alors **ajouter des scripts à chaque nouvelle version**.

Le plus simple **le temps du développement** est de disposer d'une **base de données conteneurisée** telle qu'ici.
Cela vous permettra de **recréer la base de données à chaque fois** que vous avez de nouvelles versions à **tester**
tout en vous de leur **compatibilité** entre-elles.

Vous allez alors créer des scripts versionnés pour chaque modification que vous allez faire durant votre développement.
Vous pouvez les multiplier sans souci. Ce qui compte c'est que, avant que vous ne publiiez, vous nettoyiez ces scripts
afin de réduire leur nombre (*par exemple en supprimant les essais, en rassemblant des requêtes, etc.*).

Ce qui est important, c'est de **ne *jamais* toucher les scripts préexistants une fois publiés/déployés**.
Si vous souhaitez appliquer une modification à votre base de données est qu'il y a trois scripts (*V001,V002,V003*),
vous **devez** commencer au numéro de version suivant (*V004*) même durant la phase de développement.

Pour plus de détails, je vous invite à consulter
[la documentation officielle de Flyway](https://documentation.red-gate.com/flyway/getting-started-with-flyway).