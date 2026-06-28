<script setup>
import { ref } from 'vue'
import keycloak from '@/config/keycloak'
import { BACKEND_BASE_URL } from '@/config/backend'

const dataFromApi = ref('')
const apiError = ref(null)

const inputForApi = ref(null)

async function getDataFromApiAsync(surname) {
  const apiEndpoint = `${BACKEND_BASE_URL}/users/surname/${surname}`

  //console.log(`Token from keycloak: ${keycloak.token}`)

  try {
    const responseFromApi = await fetch(apiEndpoint, {
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${keycloak.token}`,
      },
    })

    if (!responseFromApi.ok) {
      throw new Error(`Response status for user by surname: ${responseFromApi.status}`)
    }

    const result = await responseFromApi.json()

    return result
  } catch (error) {
    throw new Error(`Something went wrong with API fetch user by surname: ${error}`)
  }
}

async function submitAndSetDataFromApi() {
  apiError.value = null;

  try {
    const resultFromApi = await getDataFromApiAsync(inputForApi.value)
    dataFromApi.value = resultFromApi
  } catch (error) {
    apiError.value = error.message;
  }

  inputForApi.value = null
}
</script>

<template>
  <form @submit.prevent="submitAndSetDataFromApi">
    <input
      v-model="inputForApi"
      required
      placeholder="Give user's surname you want to get from API"
    />
    <button>Send to API</button>
  </form>

  <p>
    Message from auth API for user with given surname :
    <span v-if="apiError" class="api-answer error">{{ apiError }}</span>
    <span v-else class="api-answer valid">{{ dataFromApi }}</span>
  </p>
</template>
