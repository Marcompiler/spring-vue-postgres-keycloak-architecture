# Podman (Keycloak) - DEV

## Description

Ici se trouve les éléments nécessaires à l'instanciation d'un conteneur Podman Keycloak pour l'**environnement de développement**.

Par défaut, l'instance **Keycloak** est **déployé** sous l'adresse <http://localhost:8080>.

## Comment utiliser

La commande à exécuter pour créer/démarrer le conteneur est donc :

```sh
podman compose -f podman-compose.yml up -d
```

Pour **uniquement** le stopper :

```sh
podman stop keycloak-dev
```

Pour le stopper **et** détruire :

```sh
podman compose -f podman-compose.yml down
```
