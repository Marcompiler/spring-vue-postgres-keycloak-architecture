<script setup>
import { ref, watchEffect } from 'vue'
import keycloak from '@/keycloak'
import { BACKEND_BASE_URL } from '@/backend'

let dataFromApi = ref('')

watchEffect(async () => {
  dataFromApi.value = await getDataFromApiAsync()
})

async function getDataFromApiAsync() {
  const apiEndpoint = `${BACKEND_BASE_URL}/helloworld/admin`

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
  <p>Message from user role "admin" API : {{ dataFromApi }}</p>
</template>
