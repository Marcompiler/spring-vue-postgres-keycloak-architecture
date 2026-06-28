<script setup>
import ApiUserRoleAdmin from '@/components/ApiUserRoleAdmin.vue'
import ApiUserRegister from '@/components/ApiUserRegister.vue'
</script>

<template>
  <main>
    <h1>This is an admin page</h1>

    <hr />

    <h1>User role "admin" data from API</h1>
    <ApiUserRoleAdmin />

    <h1>Register with surname to API</h1>
    <ApiUserRegister />
  </main>
</template>
