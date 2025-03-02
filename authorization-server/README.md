# Authorization Server

Le serveur d'autorisation ici sera une instance Keycloak déployée sous forme d'un container Podman.

## But

C'est ici qu'on délègue la gestion des utilisateurs, leur authentification et leur autorisations/rôles.
De plus, de part la possibilité du SSO, si les applications se multiplient pour un même lot d'utilisateurs, leurs identifiants pourront être centralisés et réutilisés ailleurs grâce à Keycloak.
