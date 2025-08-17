podman run -d \
    --name backend \
    --net=host \
    -e SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres \
    -e SPRING_DATASOURCE_USERNAME=postgres \
    -e SPRING_DATASOURCE_PASSWORD=postgres \
    -e SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER-URI=http://localhost:8080/realms/demo-realm \
    -e SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK-SET-URI=http://localhost:8080/realms/demo-realm/protocol/openid-connect/certs \
    -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" \
    localhost/spring-vue-postgres-keycloak-architecture/backend