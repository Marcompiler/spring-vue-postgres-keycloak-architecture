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

    if (users.value.length !== 0) {
      usersHeaders.value = Object.keys(users.value[0]) // Generate table headers by users properties
    } else {
      usersHeaders.value = [];
    }

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

async function deleteUser(id) {
  const apiEndpoint = `${BACKEND_BASE_URL}/users/delete/${id}`

  try {
    const responseFromApi = await fetch(apiEndpoint, {
      headers: {
        Authorization: `Bearer ${keycloak.token}`,
      },
      method: "delete"
    })

    if (!responseFromApi.ok) {
      throw new Error(`Response status for auth: ${responseFromApi.status}`)
    }

    const indexToDelete = users.value.indexOf((user) => user.id === id);

    if (indexToDelete) {
      users.value.splice(indexToDelete, 1);
      alert("user deleted !");
    }
  } catch (error) {
    throw new Error(`Something went wrong with user deletion: ${error}`)
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
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="user in users" :key="user.id">
        <td v-for="(field, index) in user" :key="index" class="api-answer valid">{{ field }}</td>
        <td><button @click="deleteUser(user.id)" class="delete-button">Delete</button></td>
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

.delete-button {
  font-weight:bold;
  color: red;
}
</style>
