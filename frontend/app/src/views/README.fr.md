# Frontend - App - Src - Views

## Description

Ici se trouvent **les vues de l'application**, autrement dit les pages accessibles au sein de celle-ci.

Certaines sont publiques et d'autres nécessitent authentification. Il y a donc les vues suivantes :

|                    Vue                     |     Accès      | Description                                                                                                             |
| :----------------------------------------: | :------------: | :---------------------------------------------------------------------------------------------------------------------- |
|      [`HomeView.vue`](./HomeView.vue)      |     Public     | Page d'**accueil** contenant un simple appel à un **endpoint public de l'API** ainsi qu'un bouton de (dé)connexion.     |
|     [`AboutView.vue`](./AboutView.vue)     |     Public     | Page "**à propos**", pour **tester** la **navigation** sans **authentification**.                                       |
|      [`UserView.vue`](./UserView.vue)      |  Utilisateur   | Page reprenant un **ensemble d'appels** vers l'API, **nécessitant authentification** avec des accès **utilisateur**.    |
|     [`AdminView.vue`](./AdminView.vue)     | Administrateur | Page reprenant un **ensemble d'appels** vers l'API, **nécessitant authentification** avec des accès **administrateur**. |
| [`ForbiddenView.vue`](./ForbiddenView.vue) |     Public     | Page stipulant un **accès refusé** dû à un **manque de droits** d'accès **malgré l'authentification**.                  |

## Comment utiliser

Si vous voulez **afficher** des **composants/éléments supplémentaires** dans l'application, **c'est ici** que ça se passe.

Vous pouvez également **ajouter de nouvelles vues**. Dans ce cas, **n'oubliez pas** de les **référencer** dans [`router`](../router/).
