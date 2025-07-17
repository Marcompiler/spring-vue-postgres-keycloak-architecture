# Frontend - App - Src - Components

## Description

Les applications Vue.JS sont constituées de "composants" qui sont alors réutilisables et modulables au travers de l'application. La page d'accueil (*elle-même étant un composant du coup*) contient donc un ensemble de composants appelés "`Api[...]`" qui, chacun, a un objectif pour tester cette architecture.

Le tableau ci-dessous reprend donc chacun de ces composants Api[...] avec leur objectif et un ordre de complexité de 1 à 5 (*proportionnel au nombre d'éléments de l'architecture intervenant à l'atteinte de l'objectif*) :

| Nom | Objectif | Complexité |
| :---: | :--- | :---: |
| [`ApiAuthData`](./ApiAuthData.vue) | Tester l'authentification et la récupération de données nécessitant d'être authentifié. | 2 |
| [`ApiAuthDataWithForm`](./ApiAuthDataWithForm.vue) | Tester l'authentification et la récupération de données sur base d'un formulaire côté client. | 3 |
| [`ApiGetUserById`](./ApiGetUserById.vue) | Permet de vérifier qu'un utilisateur a bien été enregistré dans le backend (*et non SSO*) à partir de son identifiant généré lors de son enregistrement. | 4 |
| [`ApiGetUserBySub`](./ApiGetUserBySub.vue) | Permet de vérifier qu'un utilisateur a bien été enregistré dans le backend (*et non SSO*) à partir de son `sub` issu du SSO lors de son enregistrement. | 5 |
| [`ApiGetUserBySurname`](./ApiGetUserBySurname.vue) | Permet de vérifier qu'un utilisateur a bien été enregistré dans le backend (*et non SSO*) à partir de son surnom choisi lors de son enregistrement. | 4 |
| [`ApiGetUsers`](./ApiGetUsers.vue) | Permet de vérifier les utilisateurs enregistrés dans le backend (*et non SSO*). | 4 |
| [`ApiPublicData`](./ApiPublicData.vue) | Permet de vérifier la connexion entre le frontend et la backend au moyen d'un appel vers un endpoint publique de ce dernier. | 1 |
| [`ApiUserRegister`](./ApiUserRegister.vue) | Permet d'enregistrer l'utilisateur connecté au moyen du SSO au sein du backend, permettant alors de définir dynamiquement son `sub` issu du SSO dans le backend avec un surnom donné. | 5 |
| [`ApiUserRoleAdmin`](./ApiUserRoleAdmin.vue) | Tester l'attribution de rôles "admin" issus du SSO sur lesquels se base l'endpoint correspondant du backend. | 3 |
| [`ApiUserRoleUser`](./ApiUserRoleUser.vue) | Tester l'attribution de rôles "user" issus du SSO sur lesquels se base l'endpoint correspondant du backend. | 3 |

*N.B. : Pour rappel, l'application "backend" est ce qu'on appelle la partie "serveur" tandis que le "frontend" est la partie "cliente".*

## Comment utiliser

L'ensemble des composants `Api[...]` servent donc à tester l'architecture. En l'état actuel, ils vous serviront à vérifier que vous avez correctement déployé l'ensemble des éléments de l'architecture.

Si vous souhaitez développer des composants supplémentaires, vous pouvez donc vous baser sur ceux disponibles ici.

Les autres composants, [`HelloWorld.vue`](./HelloWorld.vue), [`TheWelcome.vue`](./TheWelcome.vue) et [`WelcomeItem.vue`](./WelcomeItem.vue), sont des composants générés par Vue lors de l'initialisation du projet.
