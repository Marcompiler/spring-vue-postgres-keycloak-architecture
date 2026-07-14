package com.marcompiler.backend.helloworld;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/helloworld")
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/{id}")
    public ResponseEntity<HelloWorld> getHelloWorldById(@PathVariable Long id) {
        return helloWorldService.getHelloWorldById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('demo:read:users')") // Role from realm-scoped roles
    public ResponseEntity<String> helloWorldUser(JwtAuthenticationToken auth) {
        return ResponseEntity.ok("Hello world dear "
            +auth.getToken().getClaimAsString(StandardClaimNames.PREFERRED_USERNAME)
            +" ("
            +auth.getToken().getClaimAsString(StandardClaimNames.SUB)
            +") !"
        );
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('demo:write:users')") // Role from realm-scoped roles
    public ResponseEntity<String> helloWorldAdmin() {
        return ResponseEntity.ok("Hello world dear admin !");
    }
}
