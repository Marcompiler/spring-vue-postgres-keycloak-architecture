<script setup>
import { ref } from 'vue'
import keycloak from '@/config/keycloak'
import { BACKEND_BASE_URL } from '@/config/backend'

const dataFromApi = ref('')
const apiError = ref(null)

const inputForApi = ref(null)

async function getDataFromApiAsync(id) {
  const apiEndpoint = `${BACKEND_BASE_URL}/helloworld/${id}`

  //console.log(`Token from keycloak: ${keycloak.token}`)

  try {
    const responseFromApi = await fetch(apiEndpoint, {
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${keycloak.token}`,
      },
    })

    if (!responseFromApi.ok) {
      throw new Error(`Response status for auth by id: ${responseFromApi.status}`)
    }

    const result = await responseFromApi.json()

    return result
  } catch (error) {
    throw new Error(`Something went wrong with auth API fetch by id: ${error}`)
  }
}

async function submitIdAndSetDataFromApi() {
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
  <form @submit.prevent="submitIdAndSetDataFromApi">
    <input
      v-model="inputForApi"
      type="number"
      required
      placeholder="Give ID you want to get from API"
    />
    <button>Send to API</button>
  </form>

  <p>
    Message from auth API :
    <span v-if="apiError" class="api-answer error">{{ apiError }}</span>
    <span v-else class="api-answer valid">{{ dataFromApi }}</span>
  </p>
</template>
