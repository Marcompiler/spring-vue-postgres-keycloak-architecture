<script setup>
import { ref, watchEffect } from 'vue'
import keycloak from '@/config/keycloak'
import { BACKEND_BASE_URL } from '@/config/backend'

const dataFromApi = ref('')
const users = ref([]);
const usersHeaders = ref([]);
const apiError = ref(null)

watchEffect(async () => {
  try {
    dataFromApi.value = await getDataFromApiAsync()

    users.value = JSON.parse(dataFromApi.value)

    // Generate table headers by users properties
    usersHeaders.value = Object.keys(users.value[0])
  } catch (error) {
    apiError.value = error.message
  }
})

async function getDataFromApiAsync() {
  const apiEndpoint = `${BACKEND_BASE_URL}/users`

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
  <p>Users : </p>
  <p v-if="apiError">
    Error trying to get users : <span class="api-answer error">{{ apiError }}</span>
  </p>
  <p v-else-if="users && users.length === 0" class="api-answer warning">
    No users found
  </p>
  <table class="users-table" v-else>
    <thead>
      <tr>
        <th v-for="(field, index) in usersHeaders" :key="index">{{ field }}</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="user in users" :key="user.id">
        <td v-for="(field, index) in user" :key="index" class="api-answer valid">{{ field }}</td>
      </tr>
    </tbody>
  </table>
</template>

<style>
.users-table {
  width: 100%;
  border-collapse: collapse;
  border: 1px solid #ddd;
}

.users-table th {
  text-align: center;
  font-weight: bold;
}

.users-table td {
  text-align: left;
  font-weight:normal;
  padding-left: 2px;
  padding-right: 2px;
}

.users-table th,
.users-table td {
  border-bottom: 1px solid #ddd;
  border-right: 1px solid #ddd;
}
</style>
