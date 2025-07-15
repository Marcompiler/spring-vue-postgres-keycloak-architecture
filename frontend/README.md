# Frontend

## Description

Ici va se trouver l'application Web avec laquelle les utilisateurs vont interagir depuis l'extérieur.

Cette application va donc permettre aux utilisateurs de naviguer au travers de pages Web dont les données seront majoritairement octroyée par le biais du [backend](../backend).
L'accès à ces mêmes données et aux interactions possibles pour l'utilisateur courant sera géré au moyen de l'[authorization server](../authorization-server).

### Composants

Les applications Vue.JS sont constituées de "composants" qui sont alors réutilisables et modulables au travers de l'application. La page d'accueil (*elle-même étant un composant du coup*) contient donc un ensemble de composants appelés "`Api[...]`" qui, chacun, a un objectif pour tester cette architecture.

Le tableau ci-dessous reprend donc chacun de ces composants Api[...] avec leur objectif et un ordre de complexité de 1 à 5 (*proportionnel au nombre d'éléments de l'architecture intervenant à l'atteinte de l'objectif*) :

| Nom | Objectif | Complexité |
| :---: | :--- | :---: |
| ApiAuthData | Tester l'authentification et la récupération de données nécessitant d'être authentifié. | 2 |
| ApiAuthDataWithForm | Tester l'authentification et la récupération de données sur base d'un formulaire côté client. | 3 |
| ApiGetUserById | Permet de vérifier qu'un utilisateur a bien été enregistré dans le backend (*et non SSO*) à partir de son identifiant généré lors de son enregistrement. | 4 |
| ApiGetUserBySub | Permet de vérifier qu'un utilisateur a bien été enregistré dans le backend (*et non SSO*) à partir de son `sub` issu du SSO lors de son enregistrement. | 5 |
| ApiGetUserBySurname | Permet de vérifier qu'un utilisateur a bien été enregistré dans le backend (*et non SSO*) à partir de son surnom choisi lors de son enregistrement. | 4 |
| ApiGetUsers | Permet de vérifier les utilisateurs enregistrés dans le backend (*et non SSO*). | 4 |
| ApiPublicData | Permet de vérifier la connexion entre le frontend et la backend au moyen d'un appel vers un endpoint publique de ce dernier. | 1 |
| ApiUserRegister | Permet d'enregistrer l'utilisateur connecté au moyen du SSO au sein du backend, permettant alors de définir dynamiquement son `sub` issu du SSO dans le backend avec un surnom donné. | 5 |
| ApiUserRoleAdmin | Tester l'attribution de rôles "admin" issus du SSO sur lesquels se base l'endpoint correspondant du backend. | 3 |
| ApiUserRoleUser | Tester l'attribution de rôles "user" issus du SSO sur lesquels se base l'endpoint correspondant du backend. | 3 |

*N.B. : Pour rappel, l'application "backend" est ce qu'on appelle la partie "serveur" tandis que le "frontend" est la partie "cliente".*

## Comment utiliser

Vous pouvez suivre le [README généré par Vue.js](./app/test-frontend-vuejs/README.md) pour démarrer l'application.

Vous pouvez également créer un profil d'exécution, par exemple dans VSCodium, pour démarrer votre application d'un simple clic.
