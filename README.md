# Web Architecture - Spring-Vue-Postgres-Keycloak Example

![Presentation image](./images/presentation.png)

## Description

This repository is an **architecture for developing a complete website** with all the necessary elements: a **backend**, a **frontend**, a **database**, and **single sign-on**.

All **using only open source elements/tools** (_as much as possible_).

## Who is this for

This project is for **anyone who**:

- **Wants to learn**.
- **Is looking** for **inspiration** to build their own architecture.
- **Wants to start developing a complete and versatile website**.
- Has lost their way here (_Welcome!_).

## Objectives

The **primary goal** is to publicly **share** what I usually do on my own **to allow others** to **be inspired** or even **motivated** to create their own designs.

This repository **can serve as a basis** for **any website project**. I hope that its composition corresponds to what you need for your particular case.
**If you have no specific requirements**, I dare say that **you have everything you need here** to develop your own solution.

I therefore invite you to **fork this project** or **do whatever you like with it** as long as it can **help/inspire/teach** you something.

## Architecture

### Architecture structure

The architecture is therefore structured as follows:

- [A REST API backend](./backend/)
  - [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
  - [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/index.html)
  - [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
- [A frontend](./frontend/)
  - [Vue.JS](https://vuejs.org/)
- [Single sign-on (SSO)](./sso/)
  - [Keycloak](https://www.keycloak.org/)
- [A database](./database/)
  - [PostgreSQL](https://en.wikipedia.org/wiki/PostgreSQL)

### How the architecture works

![Architecture diagram light-theme](images/fullstack-diagram.light-theme.png#gh-light-mode-only)
![Architecture diagram dark-theme](images/fullstack-diagram.dark-theme.png#gh-dark-mode-only)

This diagram assumes that all users have a pre-existing account within the SSO and that the user is attempting to access a "protected" resource (_requiring authentication_).

When a user attempts to access the website, a series of steps will be triggered to give them the expected result (_color code taken from the diagram, not visible on GitHub_):

1. First, **the user accesses the <span style="color:red">frontend</span>** by going to its URL.
2. **If the user is not authenticated**, they are immediately **redirected to the <span style="color:purple">SSO</span>**. The user will then have to **enter their credentials** to be **authenticated by the <span style="color:purple">SSO</span> and in the eyes of the <span style="color:red">frontend</span>**.
3. **Once authenticated**, the user is **redirected to the initial page of the <span style="color:red">frontend</span>** they were trying to access. The **<span style="color:red">frontend</span> will then load** the page content.
4. **To load content**, the **<span style="color:red">frontend</span> may need to call the <span style="color:lightgreen">backend</span>**. This call includes a Json Web Token (_JWT_) containing the identity of the user who made the initial request.
5. **To verify the user's identity and permissions**, **the <span style="color:lightgreen">backend</span> then contacts the <span style="color:purple">SSO</span> with the JWT** received to ask if it is valid.
6. **If the <span style="color:purple">SSO</span> responds positively**, this gives the **green light to the <span style="color:lightgreen">backend</span> to respond to the request from the <span style="color:red">frontend</span>** made in step 4.
7. To respond, **the <span style="color:lightgreen">backend</span> will** often **interact with the <span style="color:cyan">database</span>** to process the data requested by the request.
8. **The <span style="color:lightgreen">backend</span> finally responds to the request with the requested content**, which will **complete that of the <span style="color:red">frontend</span>**.
9. Once the content is loaded, the **<span style="color:red">frontend</span> returns the final result** to the user.

## Getting started

Here I explain **how to start the entire architecture** so that you can test it directly.
**If you want to explore it** first to **understand** it and/or **get familiar with it**, I suggest you first check **[the roadmap below](#roadmap-for-getting-started)**.

Needless to mention that **everything here** is for **development purposes**.
**For production**, you should **assign values and deploy** elements **according to your own infrastructure**.

### Prerequisites

Before you begin, make sure you have installed:

- **[Podman](https://podman.io/docs/installation)** (_or [Docker](https://docs.docker.com/get-started/get-docker/)_) to launch the database and SSO (_or the backend and frontend_).
  - **[Podman-Compose](https://podman-desktop.io/docs/compose/setting-up-compose)** (_or [Docker-Compose](https://docs.docker.com/compose/install/)_) is also recommended. Otherwise, you will need to convert the `.yml` files into `run` commands.
- **[Java 24+](https://jdk.java.net/24/)** for the Spring backend.
- **[Maven](https://maven.apache.org/download.cgi)** to build the backend.
- **[Node.js 22+](https://nodejs.org/fr/download)** and **[npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)** for the frontend.

If you haven't already done so, I recommend that you **restart your machine** once the installation(s) are complete.

### Environment variables

The database and single sign-on (SSO) depend on an environment variables file to start. So make sure you create a copy of the `.env.*.template` file and rename it by removing `.template`.

This gives:

| Item | Template file | Name of the copy |
| --- | --- | --- |
| Database | [`.env.database.template`](./database/podman/.env.database.template) | `.env.database` |
| SSO | [`.env.sso.template`](./sso/podman/dev/.env.sso.template) | `.env.sso` |

Please note that if you modify the values, you must reflect these changes in the configurations that use them:

- The values in `.env.database` are used by the backend in its [application.properties](./backend/app/src/main/resources/application.properties) and its Podman execution scripts (_[Linux](./backend/app/podman-run.sh)/[Windows](./backend/app/podman-run.ps1)_).
- The values in `.env.sso` are to be used when logging into the SSO web interface as an administrator (_default address: <http://localhost:8080>_).

Once the copies have been created and renamed, **you can then start all** the elements of the architecture [**using the commands below**](#commands-to-run).

### Commands to run

**_Make sure to follow the order of execution_**.

First of all, some elements of the architecture require Podman/Docker, so make sure that the corresponding machine exists and is started:

```sh
podman machine init
podman machine start
```

#### Database (1/4)

In a **new terminal**, run the following command to **start a Postgres container**:

```sh
cd ./database/podman/
podman-compose -f "podman-compose.yml" up
```

#### Single Sign-On (SSO) (2/4)

In a **new terminal**, run the following command to **start a Keycloak container** (_for development_):

```sh
cd ./sso/podman/dev/
podman-compose -f "podman-compose.yml" up
```

#### Backend (3/4)

In a **new terminal**, go to the **backend application directory**:

```sh
cd backend/app
```

**Start the application** using the following commands:

```sh
./mvnw clean install
./mvnw spring-boot:run
```

#### Frontend (4/4)

In a **new terminal**, go to the **frontend application directory**:

```sh
cd frontend/app
```

**Start the application** using the following commands:

```sh
npm install
npm run dev
```

**All elements are now started** and you can begin **testing your website** by going to <http://localhost:5173>. But first, our SSO is gonna say hello to us, so first, you have to [create your own users](#once-everything-started---create-your-users).

### Once everything started -> Create your users

**Once everything is started**, you have to add two users into your Keycloak instance. For that, **open your browser** and go to its address.
**By default**, it's **<http://localhost:8080>**.

When the page is shown, **enter the credentials you have set into your own [`.env.sso`](./sso/podman/dev/.env.sso)** (_be sure to have created it first !_).

Then, go to **"Manage Realms"** and click on **"demo-realm"**. If it is shown as "Current realm", go to **"Users"** and create two users by setting those values :

| Parameter Name | Value User 1 | Value User 2 |
| --- | --- | --- |
| Required user actions | None | None |
| Email verified | `On` | `On` |
| Username | demo-user | demo-admin |
| Email | <demo-user@example.com> | <demo-admin@example.com> |
| First name | Demo | Demo |
| Last name | User | Admin |
| Groups | `demo-users` | `demo-admins` |

**Once they are created**, go to their **"Credentials"** and click on **"Set password"**.
**For both**, set **"demo"** as their password and set **"Temporary" `Off`**.

**Only then** you can **login into the SSO from the frontend's redirection** (_should be something starting with "<http://localhost:8080/realms/demo-realm/protocol/openid-connect/auth[...]>"_).

## Development journey

**If you're hesitating to get started**, I was in the same situation as you for a long time and **I understand**. Therefore, **I invite you to read the [development journey](DEV_JOURNEY.md)** I wrote about this project.

If it can **help you feel less alone or even motivate you**, I would be delighted.

## Roadmap for getting started

### Recommended prior knowledge

To get started on this project, I recommend that you first acquire the **necessary knowledge** to **fully understand** the **concepts discussed here**.

I would say that the main concepts you need to know are:

- [**Container virtualization**](https://fr.wikipedia.org/wiki/Conteneur_(virtualisation)), in this case **[Podman](https://fr.wikipedia.org/wiki/Podman)**.
- What an **[API](https://fr.wikipedia.org/wiki/Interface_de_programmation)** is.
  - In this case, a **[REST](https://fr.wikipedia.org/wiki/Representational_state_transfer)** API. Note that it is only at [**level 2** of Richardson's maturity model](https://fr.wikipedia.org/wiki/Mod%C3%A8le_de_maturit%C3%A9_de_Richardson#Niveau_2_:_verbes_HTTP).
- What a **[relational database](https://fr.wikipedia.org/wiki/Base_de_donn%C3%A9es_relationnelle)** is and what **[PostgreSQL](https://fr.wikipedia.org/wiki/PostgreSQL)** is.
- The difference between **[backend](https://fr.wikipedia.org/wiki/Backend) and [frontend](https://fr.wikipedia.org/wiki/Frontal_(informatique))**.
- What **[Single Sign-On (SSO)](https://fr.wikipedia.org/wiki/Authentification_unique)** is and **the benefits of using it**.
- What is a **[Framework](https://fr.wikipedia.org/wiki/Framework)**? In our case, it is:
  - **[Spring](https://fr.wikipedia.org/wiki/Spring_(framework))** (_backend_)
  - **[Vue.js](https://fr.wikipedia.org/wiki/Vue.js)** (_frontend_)
- **The different languages used** here are:
  - [HTML](https://fr.wikipedia.org/wiki/Hypertext_Markup_Language)
  - [Java](https://fr.wikipedia.org/wiki/Java_(language))
  - [JavaScript](https://fr.wikipedia.org/wiki/JavaScript)
- The following knowledge is not covered here but may help you **complete your understanding**:
  - [CSS](https://fr.wikipedia.org/wiki/Feuilles_de_style_en_cascade)
  - [SQL](https://fr.wikipedia.org/wiki/Structured_Query_Language)

### Steps to follow

Once you feel ready to dive into this repository, I suggest you do so in this order:

1. The [**database**](./database/). Here, it is simply **a Podman script** that needs to be executed in order to be instantiated.
2. The [**SSO**](./sso/). This is also mainly just a **Podman script**, but it includes **several specific concepts**.
3. The [**backend**](./backend/). A Java Spring **application** that **relies on the first two** to function.
4. The [**frontend**](./frontend/). This is the **facade** of your architecture **that is grafted on top of the rest**.

## Tutorials used

For their implementation, I used the following tutorials, which **I invite you to consult for additional information**:

- [Spring Web - RESTful API (HATEOAS)](https://spring.io/guides/tutorials/rest) (_official Spring documentation_)
- [Spring Boot 3 KeyCloak OAuth2](https://www.youtube.com/watch?v=_0oXZKr97ro&list=PLSVW22jAG8pAXU0th247M7xPCekzeNdrH&index=10) (_YouTube video_)
- [Spring Security OAuth2 Keycloak Demo Repository](https://github.com/SaiUpadhyayula/spring-security-oauth2-keycloak-demo) (_repository from the video above_)
- [OAuth Blog - Basic SPA - Overview](https://github.com/gary-archer/oauth.blog/blob/master/public/posts/basicspa-overview.mdx)
- [Vue version 3 tutorial](https://vuejs.org/tutorial/#step-1) (_official Vue 3 tutorial_)
- [Keycloak JavaScript adapter](https://www.keycloak.org/securing-apps/javascript-adapter) (_official Keycloak documentation_)
- [Spring Boot Keycloak role-based authorization with JWT](https://medium.com/@kspoyraz7/spring-boot-keycloak-role-based-authorization-with-jwt-3bd29bdd9016) (_tutorial on roles in JWT with Spring/Keycloak_)
- [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker) (_official Spring documentation_)
- [Dockerize Vue.js App](https://v2.vuejs.org/v2/cookbook/dockerize-vuejs-app.html?redirect=true) (_official Vue documentation_)

## Tools used

### For development

- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) (_backend development_)
- [VSCodium](https://vscodium.com/) (_development of the rest of the architecture_)
- [HTTPie](https://httpie.io/) (_HTTP requests and API testing_)

### For images

- [draw.io](https://www.drawio.com/) (_diagram creation_)
- [GIMP](https://www.gimp.org/) (_logo cropping, assembly, etc._)

### Appendices

- [LibreTranslate](https://libretranslate.com/) (_translations_)
- [DeepL](https://www.deepl.com) (_translations, even if he paywalled me after some..._)
- [ChatGPT](https://chatgpt.com) (_the black sheep, it helped me understand concepts, find certain syntaxes in the code and for translations_)

## Going Further

### Containerizing backend/frontend

Deploying the database and the SSO was easy, right?  
You can provide the same option for both the backend and the frontend.

To do so, you will find a "`podman`" folder at the root of their respective directories.  
This folder contains the basic files and the necessary information to get you started on this topic.

Therefore, you can check out [the backend one](./backend/podman/) as well as [the frontend one](./frontend/podman/) as you wish.
