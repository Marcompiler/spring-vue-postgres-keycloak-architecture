<script setup>
import { ref, watchEffect } from 'vue'

let dataFromApi = ref('')

watchEffect(async () => {
  dataFromApi.value = await getDataFromApiAsync()
})

async function getDataFromApiAsync() {
  const apiEndpoint = 'http://localhost:8080/api/public'

  try {
    const responseFromApi = await fetch(apiEndpoint)

    if (!responseFromApi.ok) {
      throw new Error(`Response status for public: ${responseFromApi.status}`)
    }

    return await responseFromApi.text()
  } catch (error) {
    throw new Error(`Something went wrong with public API fetch : ${error}`)
  }
}
</script>

<template>
  <p>Message from public API : {{ dataFromApi }}</p>
</template>
