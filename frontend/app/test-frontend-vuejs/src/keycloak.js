import Keycloak from 'keycloak-js'

const keycloak = new Keycloak({
  url: 'http://localhost:8181/',
  realm: 'demo-realm',
  clientId: 'demo-vuejs',
})

export default keycloak
