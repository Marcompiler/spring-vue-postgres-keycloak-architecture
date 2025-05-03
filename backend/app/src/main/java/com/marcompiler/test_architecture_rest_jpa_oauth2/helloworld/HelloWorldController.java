package com.marcompiler.test_architecture_rest_jpa_oauth2.helloworld;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public String helloWorldUser() {
        return "Hello world dear user !";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('demo:write:users')") // Role from realm-scoped roles
    public String helloWorldAdmin() {
        return "Hello world dear admin !";
    }
}
