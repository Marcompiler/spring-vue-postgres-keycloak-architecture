<script setup>
import TheWelcome from '@/components/TheWelcome.vue'
import ApiPublicData from '@/components/ApiPublicData.vue'
import ApiAuthData from '@/components/ApiAuthData.vue'
import ApiAuthDataWithForm from '@/components/ApiAuthDataWithForm.vue'
import keycloak from '@/keycloak'
import ApiUserRoleUser from '@/components/ApiUserRoleUser.vue'
import ApiUserRoleAdmin from '@/components/ApiUserRoleAdmin.vue'
import ApiGetUsers from '@/components/ApiGetUsers.vue'
import ApiGetUserById from '@/components/ApiGetUserById.vue'
import ApiGetUserBySub from '@/components/ApiGetUserBySub.vue'
import ApiGetUserBySurname from '@/components/ApiGetUserBySurname.vue'
import ApiUserRegister from '@/components/ApiUserRegister.vue'

function logoutUser() {
  keycloak.logout()
}
</script>

<template>
  <main>
    <button @click="logoutUser">Se déconnecter</button>

    <h1>Public data from API</h1>
    <ApiPublicData />

    <h1>Auth data from API</h1>
    <ApiAuthData />

    <h1>Auth data from API by ID</h1>
    <ApiAuthDataWithForm />

    <h1>User role "user" data from API</h1>
    <ApiUserRoleUser />

    <h1>User role "admin" data from API</h1>
    <ApiUserRoleAdmin />

    <h1>Users from API</h1>
    <ApiGetUsers />

    <h1>User by ID from API</h1>
    <ApiGetUserById />

    <h1>User by SUB from API</h1>
    <ApiGetUserBySub />

    <h1>User by surname from API</h1>
    <ApiGetUserBySurname />

    <h1>Register with surname to API</h1>
    <ApiUserRegister />

    <hr />

    <h1>Content from Vue</h1>
    <TheWelcome />
  </main>
</template>
