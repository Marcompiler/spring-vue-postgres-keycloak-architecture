import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import keycloak from './config/keycloak'

// Here we define the authentication as necessary to access to the app.
async function initKeycloak() {
  await keycloak
  .init({
    onLoad: 'check-sso',

  })
  .then((authenticated) => {
    if (authenticated) {
      console.log('✅ Authenticated with Keycloak')

      // Auto-refresh token
      setInterval(() => {
        keycloak.updateToken(60).catch(() => keycloak.logout())
      }, 6000)
    } else {
      console.error('❌ Authentication failed')
    }

    const app = createApp(App)

    // Add keycloak globally
    app.config.globalProperties.$keycloak = keycloak

    app.use(router)
    app.mount('#app')
  })
}
initKeycloak();
