<script setup>
import { ref, watchEffect } from 'vue'
import keycloak from '@/keycloak'

let dataFromApi = ref('')

watchEffect(async () => {
  dataFromApi.value = await getDataFromApiAsync()
})

async function getDataFromApiAsync() {
  const apiEndpoint = 'http://localhost:8080/api/helloworld/user'

  //console.log(`Token from keycloak: ${keycloak.token}`)

  try {
    const responseFromApi = await fetch(apiEndpoint, {
      headers: {
        Authorization: `Bearer ${keycloak.token}`,
      },
    })

    if (!responseFromApi.ok) {
      throw new Error(`Response status for auth: ${responseFromApi.status}`)
    }

    return await responseFromApi.text()
  } catch (error) {
    throw new Error(`Something went wrong with auth API fetch: ${error}`)
  }
}
</script>

<template>
  <p>Message from user role "user" API : {{ dataFromApi }}</p>
</template>
