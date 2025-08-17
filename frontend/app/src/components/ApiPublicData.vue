<script setup>
import { ref, watchEffect } from 'vue'
import { BACKEND_BASE_URL } from '@/backend'

let dataFromApi = ref('')

watchEffect(async () => {
  dataFromApi.value = await getDataFromApiAsync()
})

async function getDataFromApiAsync() {
  const apiEndpoint = `${BACKEND_BASE_URL}/public`

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
