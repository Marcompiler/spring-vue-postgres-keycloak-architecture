# Comment contribuer

## Avertissement ⚠️

Avant tout : **je n'attends aucune contribution de votre part**.  
En fait, **je préfère que vous vous consacriez à vos propres projets** (_et si ceux-ci sont basés sur celui-ci, j’en serais honoré_).

Cependant, **ce dépôt est loin d'être parfait**, donc **toute contribution est toujours la bienvenue**.  
**Je vais essayer de le maintenir _autant que je peux_**, notamment pour garder les versions des dépendances à jour (_avec l'aide de Dependabot_).

## Créez votre propre branche 🌱

**Ce projet est en effet un template**. J'ai essayé qu'il **contienne uniquement le strict nécessaire** afin que chacun puisse démarrer son propre développement à partir de celui-ci.

Cependant, **si vous pensez qu’une couche ou fonctionnalité supplémentaire apporterait vraiment de la valeur** au template, **vous pouvez créer un PR** avec votre ajout afin que, **si accepté**, il devienne **disponible en tant que branche** de ce dépôt pour ceux qui souhaitent en bénéficier.

Dans ce cas, **je référencerai votre branche dans le [README racine](../README.md)** afin que les autres puissent consulter votre version du template.

Évidemment, **rien ne vous empêche de forker ce projet** afin de garder le contrôle total.

**Le choix vous appartient**.

## Comment soumettre un PR 🛠️

1. **Récupérez la dernière version de la branche principale** avant de créer votre propre branche.
2. **Créez un nom de branche clair**, ex. `feature/add-api-auth` ou `fix/frontend-navbar`.
3. Faites vos modifications **en petits commits logiques**.
4. **Testez vos modifications localement** (backend, frontend, migrations de la base de données, etc.).
5. **Soumettez votre PR** au dépôt principal avec une description claire des changements.
6. Si nécessaire, **rebasez ou squash vos commits** pour un historique propre.

## Style de code / Linting 📏

- **Java / Spring** : suivre les conventions IntelliJ / Spring.
- **Vue.js / JS** : ESLint + Prettier.
- **Docker / YAML** : indentation correcte et bonnes pratiques.
- Toujours exécuter le **linter / tests** avant de soumettre une PR.

## Tester vos modifications ✅

- Assurez-vous que **backend, frontend et base de données** fonctionnent correctement.
- Vérifiez que vos ajouts **ne cassent pas les fonctionnalités existantes**.

## Signaler des problèmes / Proposer des fonctionnalités 🐛💡

Même si vous ne comptez pas contribuer du code, vous pouvez :

- **Ouvrir une issue** pour signaler un bug.
- **Proposer une nouvelle fonctionnalité** ou amélioration.
- Utilisez des titres et descriptions clairs pour aider les mainteneurs à comprendre le problème ou la suggestion.

## Sécurité et données sensibles 🔒

- **Ne committez PAS de secrets** (mots de passe, JWT, clés API, etc.).
- Utilisez `.env[...].example` comme référence et créez votre propre `.env[...]` si nécessaire.
- Signalez toute **vulnérabilité de sécurité** via les [issues labellisées `security`](https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/issues?q=is%3Aissue%20state%3Aopen%20label%3Asecurity).

## Documentation 📝

- Mettez à jour le **README** ou les commentaires si vos changements affectent l’architecture, la configuration ou l’utilisation.
- Fournissez des **instructions claires** si vous ajoutez de nouvelles fonctionnalités ou endpoints.

## Référence des branches dans le README 🌿

- Si votre PR est acceptée, votre branche peut être **référencée dans le README racine** pour que les autres puissent la consulter.
- Cela aide les utilisateurs à **choisir une branche** selon leurs besoins ou préférences.
