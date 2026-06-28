<script setup>
import { ref, watchEffect } from 'vue'
import { BACKEND_BASE_URL } from '@/config/backend'

const dataFromApi = ref('')
const apiError = ref(null)

watchEffect(async () => {
  try {
    dataFromApi.value = await getDataFromApiAsync();
  } catch (error) {
    apiError.value = error.message;
  }
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
  <p>
    Message from public API :
    <span v-if="apiError" class="api-answer error">{{ apiError }}</span>
    <span v-else class="api-answer valid">{{ dataFromApi }}</span>
  </p>
</template>
