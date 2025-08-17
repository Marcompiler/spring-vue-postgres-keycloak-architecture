<script setup>
import { ref } from 'vue'
import keycloak from '@/keycloak'

const dataFromApi = ref('')

const inputForApi = ref('1')

async function getDataFromApiAsync(id) {
  const apiEndpoint = `http://localhost:8080/api/users/id/${id}`

  //console.log(`Token from keycloak: ${keycloak.token}`)

  try {
    const responseFromApi = await fetch(apiEndpoint, {
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${keycloak.token}`,
      },
    })

    if (!responseFromApi.ok) {
      throw new Error(`Response status for user by id: ${responseFromApi.status}`)
    }

    const result = await responseFromApi.json()

    return result
  } catch (error) {
    throw new Error(`Something went wrong with API fetch user by id: ${error}`)
  }
}

async function submitAndSetDataFromApi() {
  const resultFromApi = await getDataFromApiAsync(inputForApi.value)

  console.log(resultFromApi)

  dataFromApi.value = resultFromApi
  inputForApi.value = null
}
</script>

<template>
  <form @submit.prevent="submitAndSetDataFromApi">
    <input
      v-model="inputForApi"
      type="number"
      required
      placeholder="Give user's ID you want to get from API"
    />
    <button>Send to API</button>
  </form>

  <p>Message from auth API for user with given ID : {{ dataFromApi }}</p>
</template>
