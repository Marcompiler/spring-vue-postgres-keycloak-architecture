# Podman (Keycloak) - PROD

## Description

Ici, la procédure est plus complexe que pour la [DEV](../dev).
En effet, d'après la [documentation de Keycloak](https://www.keycloak.org/server/containers#_creating_a_customized_and_optimized_container_image), la bonne pratique est de construire 
soi-même son image Keycloak avant de l'utiliser dans un conteneur.

Pour synthétiser autant que possible, je vais résumer la procédure à la [section suivante ci-dessous](#procédure-de-déploiement).
Si plus de personnalisation s'avère nécessaire, allez voir dans la [documentation Keycloak](https://www.keycloak.org/server/containers#_creating_a_customized_and_optimized_container_image).

## Comment utiliser

En bref, il faut :

1. À partir du [template Containerfile](Containerfile.template), remplacer les valeurs selon vos besoins.
2. Construire l'image avec la commande : `podman build . -t mykeycloak`
3. Une fois l'image construite, créez et démarrez le conteneur à l'aide du [podman-compose.yml](podman-compose.yml) en l'adaptant selon votre environnement.
   1. Si vous disposez déjà d'une base de données, commentez simplement les services "[db](podman-compose.yml#L16)" et "[adminer](podman-compose.yml#L24)". Commentez également la section "[depends_on](podman-compose.yml#L7)" du service oauth.
   2. Si vous utilisez le service "[db](podman-compose.yml#L16)", veillez à assigner les mêmes valeurs que dans le Containerfile pour les identifiants etc.

NB : À l'heure actuelle, le déploiement en production ne fut **pas encore testé**.
Je vais déjà essayer de terminer un projet digne d'une production moi-même avec cette stack avant de m'y essayer...
