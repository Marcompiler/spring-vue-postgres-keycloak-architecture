# Backend - App - Main - Java - Common

## Description

Ceci est peut-être **la touche la plus personnelle** de ce projet : **la généricité**.

En effet, je tiens toujours à ce que ce que je crée soit réutilisable, comme **ce pourquoi je partage ce projet avec vous**.

Il s'agit donc ici d'une classe abstraite et de deux interfaces, chacune étant implémentée par mes classes `Entity` présentes dans les autres répertoires.

| Nom | But |
| :---: | :--- |
| [`BaseJpaEntity`](./BaseJpaEntity.java) | **Classe abstraite dont hérite les autres classes `Entity`** afin de bénéficier de **propriétés et méthodes** qui leur sont **communes**. Ici, il s'agit donc de propriétés liées aux **dates de création et de dernière modification** ainsi que l'**implémentation des deux interfaces** ci-dessous. |
| [`IAuditedEntity`](./IAuditedEntity.java) | **Interface** définissant **deux méthodes** pour des entités : une pour **obtenir sa date de création**, une autre pour **la date de sa dernière modification**. |
| [`IIdentifiableEntity<T>`](./IIdentifiableEntity.java) | **Interface template** définissant une **méthode** pour renvoyer l'**identifiant d'une entité**. Le **template** permet de **laisser le choix** quant au **type de données** de l'identifiant. |
| [`IVersionedEntity`](./IVersionedEntity.java) | **Interface** définissant une **méthode** pour renvoyer **le numéro de version de l'entité**. C'est un mécanisme ici permettant de **gérer les accès concurrents**. |

## Comment utiliser

Si vous désirez bénéficier complètement des mécanismes offerts par [Spring JPA](https://spring.io/projects/spring-data-jpa), vous pouvez simplement faire hériter vos classes entités de [`BaseJpaEntity`](./BaseJpaEntity.java).

Sinon, selon [la description ci-dessus](#description) de chaque interface, vous pouvez créer votre propre classe abstraite voire même directement implémenter les interfaces souhaitées au niveau de vos classes `Entity` selon vos besoins.

Dans le cas où vous créez votre propre classe abstraite, veillez à ajouter l'annotation [`MappedSuperclass`](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html#entity-inheritance-mapped-superclass) sur celle-ci afin que vos classes `Entity` puissent en hériter pleinement.

Veillez cependant à garder en tête, quelque soit l'issue que vous choisirez, des avantages/inconvénients de cette approche. [Cette discussion](https://stackoverflow.com/q/66045230) le résume bien à mon sens.
