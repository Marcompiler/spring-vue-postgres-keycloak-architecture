# Single Sign-On (SSO)

## Description

The authorization server here will be a [Keycloak](https://www.keycloak.org/) instance deployed as a [Podman](https://podman.io/) container.
This is where we delegate **user management**, **authentication**, and **authorizations/roles**.

In addition, **thanks to the possibility of SSO**, if applications multiply for the same group of users,
their **identity** can be **centralized and reused** elsewhere thanks to Keycloak (*the very concept of SSO*).

## How to use

First, refer to the contents of the [Podman folder](./podman/) to **launch your own Keycloak instance**.
This will depend on the environment you want.

You can also start the DEV instance, which will directly import the export created when
the container was created.

During your tests, I recommend that you only stop/restart the container without deleting it.
This is so that you don't lose your configuration (*[you can always export it](https://www.keycloak.org/server/importExport) and replace the existing export*).
When deploying **in production**, you will define **mount points** so that nothing is lost.

Once you have a functional container, you can, if you have not already done so using the pre-existing export,
follow the steps below or simply read them to understand the concepts.

### Realm

In Keycloak, you have what are called "Realms."

These are "**environments**," ‘sets’ of "clients," "user groups," and users.
This allows you to **separate client applications and users into several sets**.

We can start by **creating a realm called "demo-realm"**.

### Users

Next, when you are **in your "demo-realm"**, you will be able to **create users**.

These users will be the means by which people who wish to authenticate themselves within your applications
will be able to do so.

To do this, create a **"demo-user"** user by specifying the following information:

- Mark the email as verified.
- Specify a username, email address, first name, and last name.
- Once the user has been created, add a password (*uncheck "temporary"*).

Without this, the person will either not be able to log in from your applications,
or they will be asked for this information when they log in for the first time.

You can already create a second user **"demo-admin"** for later use.

### User groups

Next, to follow **best practices**, we will place these **users in groups**.
We will then use these same groups to define their permissions.

Still **in the "demo-realm" realm**, you can then create two groups:

- The **"demo-users"** group, to which you can add the **"demo-user"** user.
- The **"demo-admins"** group, to which you can add the **"demo-admin"** user.

### Realm roles

Now we come to the definition of **permissions**.

To do this, **in your "demo-realm"**, add the following two roles:

- The **"demo-role-users"** role, to be assigned to the **"demo-users"** group.
- The **"demo-role-admins"** role, to be assigned to the **"demo-admins"** group.

### Clients

Now all that's left is for your **applications** to be able to **go through your Keycloak** in order to authenticate
users and verify the access tokens they receive.

To achieve this, you will create "clients." These have ***many*** parameters.
In our case, during development, we can simply define the following information:

- The client ID, such as **"demo-client"**.
- Check "Standard flow".
- If you want to test using API requests (*see [HTTPie](../backend/httpie/)*), check "Direct access grants".

### Client roles

Finally, all that remains is to define **roles** at the **client** level. In fact, not only can users
be authorized based on their own roles, but the same applies to the client applications themselves.

For example, in the case of our architecture here, **the Spring API could be called by several Vue.js applications, each with a "client ID"** and therefore specific permissions.

Therefore, **in your "demo-client" client**, you can create the following roles:

- The role **"demo:read:users"**.
- The role **"demo:write:users"**.

**You now have a configuration that allows you to test several use cases: users, administrators, role verification, and client registration**.
