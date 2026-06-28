<script setup>
import ApiAuthData from '@/components/ApiAuthData.vue'
import ApiAuthDataWithForm from '@/components/ApiAuthDataWithForm.vue'
import ApiUserRoleUser from '@/components/ApiUserRoleUser.vue'
import ApiGetUserById from '@/components/ApiGetUserById.vue'
import ApiGetUserBySub from '@/components/ApiGetUserBySub.vue'
import ApiGetUserBySurname from '@/components/ApiGetUserBySurname.vue'
import ApiGetUsers from '@/components/ApiGetUsers.vue'
</script>

<template>
  <main>
    <h1>This is an user page</h1>

    <hr />

    <h1>Auth data from API</h1>
    <ApiAuthData />

    <h1>Auth data from API by ID</h1>
    <ApiAuthDataWithForm />

    <h1>User role "user" data from API</h1>
    <ApiUserRoleUser />

    <h1>User by ID from API</h1>
    <ApiGetUserById />

    <h1>User by SUB from API</h1>
    <ApiGetUserBySub />

    <h1>User by surname from API</h1>
    <ApiGetUserBySurname />

    <h1>Users from API</h1>
    <ApiGetUsers />
  </main>
</template>
