<script setup>
import { ref } from 'vue'
import keycloak from '@/keycloak'
import { BACKEND_BASE_URL } from '@/backend'

const dataFromApi = ref('')

const idForData = ref('Hello')

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
  const resultFromApi = await getDataFromApiAsync(idForData.value)

  console.log(resultFromApi)

  dataFromApi.value = resultFromApi.helloMessage
  idForData.value = null
}
</script>

<template>
  <form @submit.prevent="submitIdAndSetDataFromApi">
    <input
      v-model="idForData"
      type="number"
      required
      placeholder="Give ID you want to get from API"
    />
    <button>Send to API</button>
  </form>

  <p>Message from auth API : {{ dataFromApi }}</p>
</template>
