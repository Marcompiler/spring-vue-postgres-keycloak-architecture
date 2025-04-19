<script setup>
import TheWelcome from '../components/TheWelcome.vue'
import keycloak from '../keycloak'

function logoutUser() {
  keycloak.logout()
}
</script>

<template>
  <main>
    <button @click="logoutUser">Se déconnecter</button>
    <TheWelcome />
  </main>
</template>
