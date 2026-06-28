<template>
  <div class="forbidden">
    <h1>Forbidden access</h1>
    <p>You do not have permission to access this page.</p>
    <RouterLink to="/">Back to the home page</RouterLink>
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .forbidden {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
