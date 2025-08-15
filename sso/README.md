# Authentification unique (SSO)

## Description

Le serveur d'autorisation ici sera une instance [Keycloak](https://www.keycloak.org/) déployée sous forme d'un container [Podman](https://podman.io/).
C'est donc ici qu'on délègue la **gestion des utilisateurs**, leur **authentification** et leurs **autorisations/rôles**.

De plus, **grâce à la possibilité du SSO**, si les applications se multiplient pour un même lot d'utilisateurs, 
leur **identité** pourra être **centralisée et réutilisée** ailleurs grâce à Keycloak (*concept même du SSO*).

## Comment utiliser

Tout d'abord, fiez-vous au contenu du [dossier Podman](./podman/) pour **lancer votre propre instance Keycloak**.
Cela selon l'environnement que vous souhaitez.

Vous pouvez également démarrer l'instance de DEV qui va importer directement l'export créé à l'occasion lors de la
création du container.

Durant vos tests, je vous invite à seulement stopper/redémarrer le container sans le supprimer. 
Cela afin de ne pas perdre votre configuration (*[vous pouvez toujours l'exporter](https://www.keycloak.org/server/importExport) et remplacer l'export déjà présent*). 
Lors du déploiement **en production**, vous définirez des **points de montage** pour ne rien perdre.

Une fois que vous avez un conteneur fonctionnel, vous pouvez, si ce n'est pas déjà fait grâce à l'export préexistant,
suivre les démarches ci-dessous ou simplement les lire pour comprendre les concepts.

### Realm

Dans Keycloak, vous avez donc ce qu'on appelle des "Realm".

Ceux-ci sont donc des "**environnements**", des "ensembles" de "clients", de "groupes utilisateurs" et d'utilisateurs.
On va ainsi pouvoir **séparer les applications clientes et les utilisateurs en plusieurs ensembles**.

On peut donc commencer par **créer un realm "demo-realm"**.

### Utilisateurs

Ensuite, lorsque vous êtes **dans votre Realm "demo-realm"**, vous allez pouvoir **créer des utilisateurs**.

Ces utilisateurs seront ce à travers quoi les personnes qui souhaitent s'authentifier au sein de vos applications
pourront passer.

Pour ce faire, créez un utilisateur **"demo-user"** en spécifiant les informations suivantes :

- Considérer l'email comme vérifié.
- Spécifier un nom d'utilisateur, un email, un prénom et un nom de famille.
- Une fois l'utilisateur créé, ajoutez-lui un mot de passe (*décochez "temporaire"*).

Sans cela, la personne ne pourra soit pas se connecter depuis vos applications, 
soit ces informations lui seront de toute façon demandées à la première connexion.

Vous pouvez déjà créer un second utilisateur **"demo-admin"** pour la suite.

### Groupes utilisateurs

Ensuite, pour suivre les **bonnes pratiques**, nous allons placer ces **utilisateurs dans des groupes**.
C'est alors au moyen de ces mêmes groupes que nous définirons leurs autorisations par la suite.

Toujours **dans le realm "demo-realm"**, vous pouvez créer alors deux groupes :

- Le groupe **"demo-users"**, auquel vous pouvez ajouter l'utilisateur **"demo-user"**.
- Le groupe **"demo-admins"**, auquel vous pouvez ajouter l'utilisateur **"demo-admin"**.

### Rôles de Realm

Maintenant, nous arrivons à la définition des **autorisations**.

Pour ce faire, **dans votre realm "demo-realm"**, ajoutez les deux rôles suivants :

- Le rôle **"demo-role-users"**, à assigner au groupe **"demo-users"**.
- Le rôle **"demo-role-admins"**, à assigner au groupe **"demo-admins"**.

### Clients

Désormais, il ne manque plus qu'à ce que vos **applications** puissent **passer par votre Keycloak** afin d'authentifier
les utilisateurs et vérifier les tokens d'accès qu'elles reçoivent.

Pour y parvenir, vous allez créer des "clients". Ceux-ci ont ***beaucoup*** de paramètres.
Dans notre cas, durant le développement, nous pouvons nous contenter de définir les informations suivantes :

- Le client-ID tel que **"demo-client"**.
- Cochez "Standard flow".
- Si vous souhaitez tester au moyen de requêtes API (*voir [HTTPie](../backend/httpie/)*), cochez "Direct access grants".

### Rôles de client

Enfin, il ne manque plus qu'à définir des **rôles** au niveau du **client**. En effet, non seulement les utilisateurs peuvent
être autorisés sur base de leurs propres rôles, mais il en va de même pour les applications clientes elles-mêmes.

Par exemple, dans le cas de notre architecture ici, **l'API Spring pourrait être appelée par plusieurs applications Vue.js, chacune ayant alors un "client-ID"** et donc des autorisations particulières.

Par conséquent, **dans votre client "demo-client"**, vous pouvez créer les rôles suivants :

- Le rôle **"demo:read:users"**.
- Le rôle **"demo:write:users"**.

**Vous disposez alors d'une configuration permettant de tester plusieurs cas d'utilisation ; les utilisateurs, administrateurs, la vérification de rôles et l'enregistrement de clients**.
