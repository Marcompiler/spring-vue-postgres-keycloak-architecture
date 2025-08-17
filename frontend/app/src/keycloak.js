import Keycloak from 'keycloak-js'

const keycloak = new Keycloak({
  url: 'http://localhost:8080/',
  realm: 'demo-realm',
  clientId: 'demo-frontend',
})

export default keycloak
