package com.marcompiler.backend.helloworld;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/helloworld")
public class HelloWorldController {

    private final HelloWorldRepository helloWorldRepository;

    public HelloWorldController(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    @GetMapping
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/{id}")
    public Optional<HelloWorld> getHelloWorldById(@PathVariable Long id) {
        return helloWorldRepository.findById(id);
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('demo:read:users')") // Role from realm-scoped roles
    public String helloWorldUser(JwtAuthenticationToken auth) {
        return "Hello world dear "+auth.getToken().getClaimAsString(StandardClaimNames.PREFERRED_USERNAME)+" ("+auth.getToken().getClaimAsString(StandardClaimNames.SUB)+") !";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('demo:write:users')") // Role from realm-scoped roles
    public String helloWorldAdmin() {
        return "Hello world dear admin !";
    }
}
