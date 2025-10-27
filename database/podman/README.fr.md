# Database - Podman

## Description

C'est donc ici qu'on dispose de ce qu'il nous faut pour déployer une base de données PostgreSQL simplement grâce à [Podman](https://podman.io/).

## Comment utiliser

À partir du fichier [`.env.database.template`](./.env.database.template), **créez votre propre `.env.database`**.

Insérez-y les données que vous souhaitez. Cependant, **si vous modifiez les valeurs par défaut**, veillez à répercuter celles-ci dans la [configuration du backend](../../backend/app/src/main/resources/application.properties).

Une fois votre `.env.database` créé, vous pouvez ouvrir une invite de commande au sein de ce dossier-ci pour **exécuter la commande suivante** :

```sh
podman compose -f podman-compose.yml up -d
```

**Cela va alors déployer votre base de données** dans un conteneur accessible sous le port que vous avez choisi (*par défaut, `5432`*).
