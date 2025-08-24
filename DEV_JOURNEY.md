# Development journey

## Why this article

I thought that **sharing my journey** in **learning** these technologies and the **difficulties** I encountered could potentially **inspire and motivate others to get started**.

So here it is.

## Before starting this project

I began by **refreshing my memory** of my Java Spring courses and making several drafts of database schemas. I started **several projects that I abandoned** because **I felt stuck** due to my **lack of knowledge**, which made me feel **inadequate** and discouraged me from continuing.

Then, I **gained the necessary knowledge**, particularly through the aforementioned tutorials, **to understand exactly what I was going to use and why**.
I had to **accept that I couldn't do everything well from the start**, which, even today, remains difficult.

## Assembling a backend

After several attempts, setbacks, and even failures, I finally managed to **gradually** build a **functional foundation between the database, the backend, and the SSO**. This helped me **regain confidence in myself** and **in my development stack**, which was also a nightmare to build in order to **combine comfort and personal values**.

Once I was able to truly **understand** the **Authorization Code Flow**, I was able to start thinking about how to tackle the frontend.

I then managed to **create my VueJS application** (_Vue 3_) with `npm` and decided to **follow the tutorial linked** to the framework. **Once I had the basics** of Vue, I tried to figure out how to **implement Keycloak** in the application.

Once I succeeded, it **motivated me even more to continue**: I was now able to **communicate my SSO with both my API and my frontend**. I knew then that all I had to do was get the frontend to communicate with the API, and then all the basic pieces of the puzzle would finally be in place.

## Getting started with the frontend

The next day, I got back to work, **learned** how to make requests with `fetch` in JavaScript, managed CORS in the API, and then called the various API endpoints. **Everything worked**.
It was a real relief because I knew then that **the stack I had built was functional**.

Then, being **specialized in backend** initially, I looked for a **CSS framework with components** to compare alternatives to [Element Plus](https://element-plus.org), just to see.
I then discovered [PrimeVue](https://primevue.org/) which, despite having fewer stars than others, seemed reliable, comprehensive, and clearly documented.

**Nevertheless**, I wanted **this project to be limited to what was necessary** while **leaving the choice** of technologies that go **beyond the scope of this project** open. So I finally decided to mention the two CSS frameworks above to let you choose between them or others, whichever you prefer.

## User management

Finally, **the final nail in the coffin** for this project seemed to me to be something that would be necessary anyway for the future: **user management at the backend database level**. Indeed, we don't generally limit ourselves to SSO for our users; SSO simply authenticates and secures the data necessary for this authentication.

**For application-specific data** related to the same users, it must therefore be managed within the application. Not to mention that I haven't yet tried to **interpret the roles defined by SSO in the backend**. This then became my **next goal**.

During a weekend away from home, I took advantage of some free time on my laptop to investigate how to **implement roles** in my architecture. I then discovered the different types of roles in Keycloak.
There are **two types of roles**:

- Roles at the **Realms** level.
- Roles at the **client** level.

Once I was able to **understand** the difference between the two, I was able to find them within my Spring API.
Having already had to manage SSO claims in my work, I quickly understood how roles were transported within JWTs.

Then, **using a tutorial** (_which, I must say, had a few inconsistencies, particularly between the article and the associated repository_) **combined with AI**, I ended up building an **architecture** that seemed **sufficiently robust and modular** to me.

At this point, I am almost certain that I have **only one step** left: **managing SSO claims**.
This is particularly important for retrieving user identifiers so that I can associate them with specific data at the Spring API level in the dedicated Postgres database.
I therefore also need to build a **base for the user data structure** to give shape to this.

## Contemplation

And... **there you have it**. This was the last stage (_easy to achieve compared to the rest_) that I could imagine so far and which seemed essential to me in order to fully embark on a project.
Indeed, we now have:

- a reliable, robust, and versatile **database**.
- a **backend** that connects to the database and generates its content automatically.
- a **frontend** that connects to the backend to interact with the data through the secure portal that the backend represents.
- a **single sign-on** (_SSO_) system for authenticating and managing user permissions.

All of these components **interact with each other** in a functional manner while being **made up of open source elements**, each with a solid reputation and great versatility.

## Final touch

The **icing on the cake before sharing** all this is to **document everything** as best as possible so that anyone wishing to get started has clear information and a solid foundation (at least for reflection) to bring their ideas to fruition.

I finally found the time to complete the remaining documentation. I will try to establish a "learning roadmap" that I would recommend following to best understand this directory, but this will obviously remain subjective.

## Conclusions

**This project is coming to an end**, or at least its completion, as it is finally being published. I have **no idea whether people will like it** or not, or even if it will really be useful to anyone, or if this project is 100% reliable.

All I know is that **I needed to do it and I did my best**. I think **that's what matters**. Beyond that, if anyone is reading this, **I wish you all the best** and hope that I have been a **source of inspiration, motivation, or even just entertainment**.

## Mistakes and solutions

### REST API != RESTful API != RPC API

After reading the [Spring tutorial on building a RESTful API](https://spring.io/guides/tutorials/rest) carefully and realizing that **I was mistaken** about what I thought a REST API was, **I hesitated for a long time about whether to include these new concepts** in this repository.

~~**I finally concluded** that I would make it clear **that this would be an [RPC API](https://en.wikipedia.org/wiki/Remote_procedure_call)** so that those who needed to could implement the "REST" nature of their future API themselves based on what they had learned here (_as I did on this_).~~

Given the structure of **the backend**, it **still looked more like REST than "basic" RPC**. So I kept searching, and that's when I finally understood the **difference between "REST" and "RESTful"**. Therefore, we can consider **the backend** here as **REST but not RESTful because it lacks [hypermedia](https://en.wikipedia.org/wiki/HATEOAS)**.

More specifically, if we use the **[Richardson maturity model](https://en.wikipedia.org/wiki/Richardson_Maturity_Model)**, we can classify **this API as [level 2](https://en.wikipedia.org/wiki/Richardson_Maturity_Model#Level_2:_HTTP_verbs)**. [Level 3](https://en.wikipedia.org/wiki/Richardson_Maturity_Model#Level_3:_Hypermedia_controls) therefore requires hypermedia. This level suits me because **hypermedia is not necessary here or for others**. Not to mention, above all, that it makes reading the **code much easier for a beginner**.

### Difficulties in completing

**I was tempted several times to abandon this project**.

In addition to the fact that I am not only interested in programming but also in computer science in general, **I found it difficult to focus** here in order to complete this project.
To achieve this, **I forced myself to program nothing else but this project and its documentation**. This was difficult for me because I kept thinking about what needed to be finished here without actually doing it.

What was fascinating was that it wasn't even **really complicated, just voluminous**. Especially since **having to stick to something like this, so much and for so long, proved particularly difficult** for me. When I have clear objectives set out and given to me by someone else, it's easy. But when you have to do it yourself from start to finish, it can sometimes be quite difficult to stick to it...

Nevertheless, **I think I've managed to put together something that's at least somewhat decent**, so **I hope it can help anyone reading this**. Even if it's just one person looking for inspiration.
