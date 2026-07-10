# Backend - App - Main - Resources

## Description

Ceci est la **configuration** de l'application backend.

On y définit donc, au moyen de [`application.properties`](./application.properties), des **propriétés à appliquer pour l'exécution** de l'application.

Il y a également les [**migrations de base de données**](db/migrations) permettant de **mettre à jour la structure de données** au sein de celle-ci au fur et à mesure des versions.

## Comment utiliser

**En l'état**, [`application.properties`](./application.properties) définit **l'ensemble des paramètres dont vous avez besoin** pour l'exécution de l'architecture **par défaut**.

Néanmoins, **vous pouvez redéfinir les valeurs** comme bon vous semble pour l'exécution en l'état et/ou pour votre propre développement.

Attention, si vous modifiez les valeurs, **veillez à les répercuter au sein des autres éléments** de l'architecture !

*N.B. : Si vous souhaitez **explorer les possibilités** de configuration, vous pouvez vous fier notamment à la [documentation officielle de Spring à ce sujet](https://docs.spring.io/spring-boot/appendix/application-properties/index.html).*
