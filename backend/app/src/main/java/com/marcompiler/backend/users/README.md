# Backend - App - Main - Java - Users

## Description

**Toute application nécessitant authentification nécessite par conséquent de gérer un tant soit peu ses utilisateurs**.

**L'authentification** en tant que tel, **c'est le SSO** qui s'en occupe. Néanmoins, il peut être intéressant de **conserver des informations supplémentaires** propres à **notre application** pour nos utilisateurs. C'est là que rentre en jeu ce répertoire.

Par conséquent, nous avons ici **trois éléments** :

- Une classe pour l'**entité "MyUser"**.
- Un **controller** pour contrôler la manipulation de ces entités.
- Un **repository** pour récupérer/conserver/modifier ces entités.

### MyUser.java

La **[classe MyUser](./MyUser.java)** constitue donc un **utilisateur au niveau de notre application**. On y stocke donc des **informations propres** au contexte de cette dernière tel qu'**un identifiant unique et un surnom**.

Néanmoins, puisque les utilisateurs sont authentifiés grâce au SSO, il nous faut un moyen de faire **le lien entre** l'identité de l'utilisateur aux yeux du **SSO et notre application**. On va donc ajouter **dans notre classe** un champ **`sub`** qui sera alors l'identifiant unique représentant l'utilisateur au sein du SSO.

**Cet identifiant** peut être **récupéré depuis le [Json Web Token (*JWT*)](https://fr.wikipedia.org/wiki/JSON_Web_Token)** fourni **lors de l'enregistrement** de la personne auprès de notre application. **Cet enregistrement se fait au sein du controller**.

### MyUserController.java

Le **[controller MyUserController](./MyUserController.java)** va alors offrir plusieurs fonctionnalités pour le frontend afin d'effectuer des **actions indirectes sur les utilisateurs** enregistrés au sein **de notre application**.

**Pour que ceux-ci soient enregistrés**, il faut le permettre, c'est le rôle de la **méthode `register`**. Reprenons son code ici :

```java
@PostMapping("/register")
public ResponseEntity<?> register(JwtAuthenticationToken auth, @RequestBody Map<String, String> payload)
{
    try {
        String sub = auth.getToken().getClaimAsString(StandardClaimNames.SUB);
        String surname = payload.get("surname");

        MyUser newUser = new MyUser(sub, surname);

        MyUser result = userRepository.save(newUser);

        return ResponseEntity.ok(result.getId());
    }
    catch(DataIntegrityViolationException ex) {
        // Si un utilisateur avec le même surnom/sub existe déjà, erreur car colonne NOT NULL et UNIQUE
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("A user with the same sub/username already exists !");
    }
    catch (Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error while registering user: " + ex.getMessage());
    }
}
```

C'est donc un endpoint qu'on appelle sous le chemin "`/register`" de notre API. Cette méthode possède **deux paramètres** :

- **`auth`** : Il s'agit du JWT qui, suite à l'authentification de la personne auprès du SSO, va l'enregistrer au sein de notre base de données en passant par le [repository](#myuserrepositoryjava).
- **`payload`** : C'est le contenu du body de la requête qui, dans ce cas-ci, est censé contenir un surnom pour le nouvel utilisateur.

**De `auth` on récupère le `sub` et du `payload` on récupère le surnom**. On instancie alors un nouvel utilisateur avec ces informations puis on tente de l'enregistrer à l'aide de notre [repository](#myuserrepositoryjava).

**Si** ce dernier détecte un **conflit**, par exemple que le surnom et/ou le `sub` existe déjà au sein de la base de données, il renverra alors une **réponse HTTP explicitant ce conflit**. Cela pour signifier que l'utilisateur est déjà enregistré ou que le pseudo est déjà utilisé.

Pour savoir cela, il faut du coup avoir su **sauvegarder des utilisateurs** dans la base de données. C'est alors **au tour du [repository](#myuserrepositoryjava) de jouer**.

### MyUserRepository.java

Le **[repository MyUserRepository](./MyUserRepository.java)** va alors jouer le rôle d'**interface entre notre base de données et l'application** afin que cette dernière puisse interagir avec la première. On a alors les **méthodes héritées de [`JpaRepository`](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html) mais aussi d'autres méthodes** telles que trouver un utilisateur au moyen du `sub` ou de son surnom.

## Comment utiliser

Depuis le frontend ou HTTPie, **veillez d'abord à vous être authentifié auprès du SSO et d'avoir récupéré un JWT**.

Ensuite, **appelez l'endpoint** du controller pour vous enregistrer au sein de l'API **avec le JWT et un surnom** dans le corps de la requête. Par défaut, il s'agit de :

```sh
http://localhost:8080/api/users/register
```

Vous obtiendrez alors une **réponse HTTP 200 (OK) avec l'identifiant de l'utilisateur généré par l'API**. Vous pourrez alors retrouver/manipuler l'utilisateur à l'aide du `sub` ou de l'identifiant unique propre à notre base de données.

Vous pouvez alors essayer de récupérer le nouvel utilisateur à l'aide de l'une des méthodes `getUserBy[...]`.
