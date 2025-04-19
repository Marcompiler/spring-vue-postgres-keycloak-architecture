import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import keycloak from './keycloak'

await keycloak
  .init({
    onLoad: 'login-required',
  })
  .then((authenticated) => {
    if (authenticated) {
      console.log('✅ Authenticated with Keycloak')

      // Auto-refresh token
      setInterval(() => {
        keycloak.updateToken(60).catch(() => keycloak.logout())
      }, 6000)

      const app = createApp(App)

      // Ajouter keycloak globalement
      app.config.globalProperties.$keycloak = keycloak

      app.use(router)
      app.mount('#app')
    } else {
      console.error('❌ Authentication failed')
    }
  })
