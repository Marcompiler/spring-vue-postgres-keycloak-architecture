# Backend - App - Main - Java - Common

## Description

This is perhaps **the most personal touch** of this project: **genericity**.

Indeed, I always aim for what I create to be reusable, which is **why I am sharing this project with you**.

Here, we have an abstract class and two interfaces, each implemented by my `Entity` classes found in other directories.

| Name | Purpose |
| :---: | :--- |
| [`BaseJpaEntity`](./BaseJpaEntity.java) | **Abstract class inherited by other `Entity` classes** to provide **common properties and methods**. Here, it includes properties related to **creation and last modification dates** as well as the **implementation of the two interfaces** below. |
| [`IAuditedEntity`](./IAuditedEntity.java) | **Interface** defining **two methods** for entities: one to **get the creation date**, and another to **get the last modification date**. |
| [`IIdentifiableEntity<T>`](./IIdentifiableEntity.java) | **Template interface** defining a **method** to return the **identifier of an entity**. The **template** allows choosing the **data type** of the identifier. |
| [`IVersionedEntity`](./IVersionedEntity.java) | **Interface** defining a **method** to return the **version number of the entity**. This mechanism helps **manage concurrent access**. |

## How to Use

If you want to fully benefit from the mechanisms provided by [Spring JPA](https://spring.io/projects/spring-data-jpa), you can simply have your entity classes inherit from [`BaseJpaEntity`](./BaseJpaEntity.java).

Otherwise, based on [the description above](#description) of each interface, you can create your own abstract class or even directly implement the desired interfaces in your `Entity` classes as needed.

If you create your own abstract class, make sure to add the [`MappedSuperclass`](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html#entity-inheritance-mapped-superclass) annotation so that your `Entity` classes can fully inherit from it.

However, keep in mind, regardless of the approach you choose, the pros and cons of this method. [This discussion](https://stackoverflow.com/q/66045230) summarizes it well in my opinion.
