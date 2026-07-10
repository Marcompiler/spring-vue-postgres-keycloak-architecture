# Backend - App - Database Migrations

## Description

Here you'll find all the database migration scripts.

We use [Flyway](https://en.wikipedia.org/wiki/Flyway_(software)) to manage these migrations.
Each time it starts up, the backend application will query the database to verify
which version it is running compared to the scripts here.

Depending on the response, **the backend will then execute** these scripts, **in order**, until the database
is at the same version as the scripts.

For example, if you have three scripts prefixed with “V001,” “V002,” and “V003,” respectively, the backend will execute them
in that order in the database.

## How to Use

If you need to adjust your data structure, you’ll have to **add scripts to each new version**.

The simplest approach **during development** is to use a **containerized database** like the one shown here.
This will allow you to **recreate the database every time** you have new versions to **test**
while ensuring their **compatibility** with one another.

You will then create versioned scripts for every change you make during development.
You can create as many as you need without worry. What matters is that, before you release, you clean up these scripts
to reduce their number (*for example, by removing test cases, combining queries, etc.*).

It’s important to **never *touch* pre-existing scripts once they’ve been published/deployed**.
If you want to apply a change to your database and there are three scripts (*V001, V002, V003*),
you **must** start with the next version number (*V004*) even during the development phase.

For more details, please refer to
[the official Flyway documentation](https://documentation.red-gate.com/flyway/getting-started-with-flyway).
