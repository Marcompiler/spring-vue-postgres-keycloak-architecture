<script setup>
import { ref, watchEffect } from 'vue'
import keycloak from '@/config/keycloak'
import { BACKEND_BASE_URL } from '@/config/backend'

const dataFromApi = ref('')
const apiError = ref(null)

watchEffect(async () => {
  try {
    dataFromApi.value = await getDataFromApiAsync()
  } catch (error) {
    apiError.value = error.message;
  }
})

async function getDataFromApiAsync() {
  const apiEndpoint = `${BACKEND_BASE_URL}/helloworld/user`

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
  <p>
    Message from user role "user" API :
    <span v-if="apiError" class="api-answer error">{{ apiError }}</span>
    <span v-else class="api-answer valid">{{ dataFromApi }}</span>
  </p>
</template>
