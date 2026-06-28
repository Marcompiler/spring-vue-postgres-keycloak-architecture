# Frontend - App - Src - Views

## Description

This is where you will find **the application views**, in other words, the pages accessible within the application.

Some views are public, while others require authentication. The available views are as follows:

|                    View                    |    Access     | Description                                                                                                   |
| :----------------------------------------: | :-----------: | :------------------------------------------------------------------------------------------------------------ |
|      [`HomeView.vue`](./HomeView.vue)      |    Public     | **Home** page containing a simple call to a **public API endpoint**, along with a **login/logout** button.    |
|     [`AboutView.vue`](./AboutView.vue)     |    Public     | **About** page used to **test navigation** without **authentication**.                                        |
|      [`UserView.vue`](./UserView.vue)      |     User      | Page containing a **set of API calls** that **require authentication** with **user-level** access.            |
|     [`AdminView.vue`](./AdminView.vue)     | Administrator | Page containing a **set of API calls** that **require authentication** with **administrator-level** access.   |
| [`ForbiddenView.vue`](./ForbiddenView.vue) |    Public     | Page indicating **access denied** due to **insufficient permissions**, **despite successful authentication**. |

## How to use

If you want to **display** **additional components/elements** in the application, **this is where** it happens.

You can also **add new views**. In this case, **don't forget** to **reference** them in [`router`](../router/).
