package com.marcompiler.test_architecture_rest_jpa_oauth2.helloworld;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/helloworld")
@CrossOrigin(origins = "*") // Only for development purposes
public class HelloWorldController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return "Hello world";
    }
}
