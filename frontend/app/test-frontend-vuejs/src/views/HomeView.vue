<script setup>
import TheWelcome from '@/components/TheWelcome.vue'
import ApiPublicData from '@/components/ApiPublicData.vue'
import ApiAuthData from '@/components/ApiAuthData.vue'
import ApiAuthDataWithForm from '@/components/ApiAuthDataWithForm.vue'
import keycloak from '@/keycloak'

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

    <hr />

    <h1>Content from Vue</h1>
    <TheWelcome />
  </main>
</template>
