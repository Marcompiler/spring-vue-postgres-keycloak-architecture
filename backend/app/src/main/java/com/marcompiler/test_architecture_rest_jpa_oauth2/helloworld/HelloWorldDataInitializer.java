package com.marcompiler.test_architecture_rest_jpa_oauth2.helloworld;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldDataInitializer implements CommandLineRunner {

    private final HelloWorldRepository helloWorldRepository;

    public HelloWorldDataInitializer(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    @Override
    public void run(String... args) {
        if (helloWorldRepository.findByHelloMessage("Bonjour le monde").isEmpty()) {
            helloWorldRepository.save(new HelloWorld("Bonjour le monde"));
        }

        if (helloWorldRepository.findByHelloMessage("Hello World").isEmpty()) {
            helloWorldRepository.save(new HelloWorld("Hello World"));
        }

        if (helloWorldRepository.findByHelloMessage("Hola Mundo").isEmpty()) {
            helloWorldRepository.save(new HelloWorld("Hola Mundo"));
        }
    }
}
