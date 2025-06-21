<script setup>
import { ref } from 'vue'
import keycloak from '@/keycloak'

const dataFromApi = ref('')

const inputForApi = ref('')

async function getDataFromApiAsync(surname) {
  const apiEndpoint = `http://localhost:8080/api/users/register`

  //console.log(`Token from keycloak: ${keycloak.token}`)

  try {
    const responseFromApi = await fetch(apiEndpoint, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${keycloak.token}`,
      },
      body: JSON.stringify({
        surname: surname,
      }),
    })

    const responseBody = await responseFromApi.text() // On lit toujours le body (qu’il soit JSON ou pas)

    if (!responseFromApi.ok) {
      throw new Error(`Response for registering with surname: ${responseBody}`)
    }

    const result = JSON.parse(responseBody)

    return result
  } catch (error) {
    throw new Error(`Something went wrong with API registering user by surname: ${error}`)
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
    <input v-model="inputForApi" required placeholder="Give your username to register to the API" />
    <button>Send to API</button>
  </form>

  <p>Message from auth API for user with given surname : {{ dataFromApi }}</p>
</template>
