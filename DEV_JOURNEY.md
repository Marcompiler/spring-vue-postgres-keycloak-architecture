# Parcours de développement

## Pourquoi cet écrit

J'ai pensé que **partager mon parcours** sur la **prise en main** de ces technologies et des **difficultés** que j'ai rencontrées pourraient potentiellement **inspirer voire motiver d'autres à se lancer**.

Le voici donc.

## Avant d'entamer ce projet

J'ai commencé par me faire des **piqûres de rappel** quant à mes cours sur Java Spring et à faire plusieurs brouillons de schémas de base de données. J'ai entamé **plusieurs projets que j'ai abandonnés** car **je me sentais bloqué** par mon **manque de connaissances**, générant chez moi un **sentiment d'illégitimé** qui me dissuadait alors de continuer.

Ensuite, j'ai **accumulé les connaissances nécessaires**, notamment aux moyens des tutoriels susmentionnés, **pour comprendre exactement ce que j'allais utiliser et pourquoi**.
J'ai dû **accepter de ne pas pouvoir tout bien faire dès le départ**, ce qui, encore à ce jour, reste compliqué.

## Assemblage d'un backend

Après plusieurs tâtonnements, des dérapages, voire des décrochages, j'ai fini par constituer **petit à petit** une **base fonctionnelle entre la base de données, le backend et le SSO**. Cela m'a aidé à **reprendre confiance en moi** ainsi qu'**en ma stack de développement** qui, elle aussi, fut un calvaire à constituer afin d'**allier confort et valeurs personnelles**.

Une fois que j'ai pu **comprendre** vraiment l'**Authorization Code Flow**, j'ai pu commencer à réfléchir sur comment entreprendre la partie frontend.

J'ai alors réussi à **créer mon application VueJS** (_Vue 3_) avec `npm` puis ai décidé de **suivre le tutoriel lié** au framework. **Une fois que j'ai eu les bases** de Vue, j'ai essayé de trouver comment **implémenter Keycloak** dans l'application.

Une fois que j'y suis parvenu, ça m'a d'autant plus **motivé à continuer** : je parvenais désormais à faire **communiquer mon SSO autant avec mon API qu'avec mon frontend**. Je savais alors que je n'avais plus qu'à faire communiquer le frontend avec l'API et, là, toutes les pièces du puzzle de base seraient enfin assemblées.

## Prise en main du frontend

Dès le lendemain, je m'y suis remis, **ai appris** comment faire des requêtes avec `fetch` en JavaScript, gérer le CORS dans l'API puis ai appelé les différents endpoints de l'API, **tout fonctionnait**.
Ce fut un vrai relâchement car je sus alors que **la stack que j'avais constituée était fonctionnelle**.

Ensuite, étant **spécialisé backend** initialement, j'ai recherché un **framework CSS avec composants**, cela afin de comparer les alternatives au lieu d'[Element Plus](https://element-plus.org), juste pour voir.
J'ai alors découvert [PrimeVue](https://primevue.org/) qui, malgré un nombre d'étoiles moins important que d'autres, m'a semblé fiable, complet et clairement documenté.

**Néanmoins**, j'ai tenu à ce que **ce projet se limite au nécessaire** tout en **laissant le choix** sur les technologies qui vont **au-delà de la portée prévue** par ce projet. Je me suis donc finalement contenté de mentionner les deux frameworks CSS ci-dessus afin de vous laisser choisir, parmi eux ou d'autres encore, ce que vous préférez.

## Gestion des utilisateurs

Enfin, **le clou final** à ce projet m'a paru être ce qui allait être de toute façon nécessaire pour la suite : **la gestion des utilisateurs au niveau du backend-database**. En effet, on ne se limite généralement pas au SSO pour nos utilisateurs ; celui-ci se contente d'authentifier et de sécuriser les données nécessaires à cette authentification.

**Pour les données propres à l'application**, liées aux mêmes utilisateurs, il faut donc les gérer au sein de celle-ci. Sans parler que je n'ai pas encore essayé d'**interpréter les rôles définis par le SSO dans le backend**. C'est alors devenu mon **prochain objectif**.

Durant un week-end hors de chez moi, j'ai profité d'un instant sur mon portable pour investiguer sur comment **implémenter les rôles** au niveau de mon architecture. J'ai alors découvert les différents types de rôles dans Keycloak.
Il y a alors **deux types de rôles** :

- Les rôles au niveau des **Realms**.
- Les rôles au niveau des **clients**.

Une fois que j'ai pu **comprendre** la différence entre les deux, j'ai pu les retrouver au sein de mon API Spring.
Ayant déjà dû gérer des claims SSO au sein de mon travail, j'ai rapidement compris comment étaient transportés les rôles au sein des JWT.

Ensuite, **en usant d'un tutoriel** (_qui, je dois dire, comportait quelques incohérences, notamment entre l'article et le repository associé_) **combiné à l'aide de l'IA**, j'ai fini par constituer une **architecture** qui m'a paru **suffisamment solide et modulaire**.

À ce stade, je suis pratiquement certain qu'il ne me reste **plus qu'une seule étape** : **gérer les claims SSO**.
Ce notamment pour récupérer les identifiants utilisateurs afin de pouvoir leur associer des données spécifiques au niveau de l'API Spring dans la base de données Postgres dédiée.
Il faut donc également constituer une **base pour la structure de données des utilisateurs** pour donner forme à cela.

## Contemplation

Et... **voilà**. Ce fut le dernier stade (_étonnement facile comparé au reste_) que j'ai pu imaginer jusqu'ici et qui me semblait être essentiel pour débuter pleinement un projet.
En effet, on dispose désormais :

- d'une **base de données** fiable, solide et polyvalente.
- d'un **backend** se connectant à la base de données et générant son contenu automatiquement.
- d'un **frontend** se connectant au backend pour interagir avec les données au travers du portail sécurisé que représente le backend.
- d'un **single-sign on** (_SSO_) permettant d'authentifier voire gérer les autorisations des utilisateurs.

Le tout **interagissant les uns avec les autres** de manière fonctionnel tout en étant **constitués que d'éléments open source** avec chacun une réputation solide et une grande polyvalence.

## Touche finale

La **cerise sur le gâteau avant de partager** tout cela est de **documenter le tout** au mieux afin que quiconque souhaitant se lancer puisse disposer d'informations claires et d'une base (_au moins de réflexion_) solide pour concrétiser ses idées.

J'ai alors enfin pu trouver le temps pour compléter la documentation restante. Je vais essayer d'établir une "**roadmap d'apprentissage**" que j'inviterais à suivre pour comprendre au mieux ce répertoire mais **cela restera évidemment subjectif**.

## Erreurs de parcours et solutions

### API REST != API RPC

Après m'être rendu compte, en ayant lu correctement le [tutoriel de Spring pour construire une API RESTful](https://spring.io/guides/tutorials/rest) et me rendre compte que **j'étais dans l'erreur** quant à ce que je pensais qu'étais une API REST, **j'ai alors longuement hésité à inclure ces nouveaux concepts** au sein de ce repository.

**J'ai fini par conclure** que j'allais expliciter **qu'il s'agirait ici d'une [API RPC](https://fr.wikipedia.org/wiki/Appel_de_proc%C3%A9dure_%C3%A0_distance)** afin de laisser la possibilité, pour ceux qui le nécessitent, d'implémenter eux-mêmes le caractère "REST" de leur future API sur base de ce qu'ils auront appris ici (_comme moi là-dessus_).

### Difficultés à terminer

**J'ai été tenté à plusieurs reprises d'arrêter ce projet**.

Outre le fait que je ne m'intéresse pas qu'à la programmation mais bien à l'informatique dans sa généralité, **j'ai eu du mal à me focaliser** ici pour parvenir à conclure ce projet.
Pour y parvenir, **je me suis obligé à ce que je ne puisse rien programmer d'autre que ce projet et sa documentation**. Cela fut compliqué pour moi car je ne cessais de ressasser ce qu'il fallait terminer pour ici sans pour autant m'y adonner.

Ce qui fut fascinant est que ce n'était même **pas réellement compliqué mais volumineux**. Surtout que **devoir se tenir à quelque chose ainsi, autant et sur la durée, ça s'est révélé particulièrement difficile** pour moi. Autant lorsque j'ai des objectifs clairs énoncés et donnés par l'extérieur, c'est facile. Autant le faire de soi-même de bout en bout, c'est parfois assez compliqué de s'y tenir...

Néanmoins, **je pense être parvenu à constituer quelque chose d'un tant soit peu correct** alors **j'espère que cela pourra aider quiconque lisant ceci**. Ne serait-ce qu'une personne cherchant de l'inspiration.
