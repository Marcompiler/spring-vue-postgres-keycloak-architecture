# Podman (Keycloak)

## Description

Ici se trouve les éléments liés à Keycloak pour instancier des conteneurs Podman se basant sur une image de Keycloak.

Dû à la configuration avancée que permet Keycloak, j'ai séparé ce dossier en plusieurs environnements qui sont :

- [L'environnement de développement (**DEV**)](./dev)
- [L'environnement de production (**PROD**)](./prod) (*non testé*)

## Comment utiliser

Durant la phase de développement, contentez-vous d'instancier des conteneurs avec la configuration de DEV prévue.
Elle est suffisamment complète, d'après la portée prévue par ce projet de démarrage, pour tester vos cas d'utilisation.

Lors du déploiement en production, je vous invite à considérer la partie dédiée correspondante afin d'avoir une idée
du chemin à prendre. Néanmoins, je précise que, n'ayant pas encore pu exploiter cette stack moi-même pour 
un environnement de production, je vous conseille de vous fier avant tout à la documentation officielle de Keycloak.