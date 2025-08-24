# Podman (Keycloak) - DEV - Import

## Description

Ici se trouve un **export du realm** mentionné précédemment **pour vos tests avec Keycloak**.

Le realm comporte donc des groupes utilisateurs, des rôles, etc. permettant de tester les fonctionnalités du reste de ce dépôt.

## Comment utiliser

**Lorsque vous démarrerez le conteneur Podman Keycloak DEV** à l'aide du [`podman-compose.yml`](../podman-compose.yml) dédié, **cet export sera automatiquement importé** dans le conteneur Keycloak grâce à la commande `--import-realm` et le point de montage avec ce dossier.
