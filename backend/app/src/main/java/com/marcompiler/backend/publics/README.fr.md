# Backend - App - Main - Java - Public

## Description

Ceci est la **partie la plus simple** de l'application : **un simple controller** attendant une requête HTTP sur **un endpoint** donné.

C'est en effet **le seul endpoint** de l'application **qui ne nécessite aucune authentification** auprès de l'API pour pouvoir interagir avec cette dernière.

Celui-ci **permet donc de s'assurer**, en plus de comprendre la base de ce qui fait de cette application une API, **que cette dernière fonctionne** en l'appelant depuis le frontend ou un testeur tel que HTTPie.

## Comment utiliser

Depuis le frontend ou HTTPie, **appelez l'endpoint** du controller. Par défaut, il s'agit de :

```sh
http://localhost:8081/api/public
```

Vous obtiendrez alors une **réponse HTTP 200 (OK) : "`Hello public`"**. Celle-ci vous permet de savoir que **votre API est bien démarrée et est accessible**.
