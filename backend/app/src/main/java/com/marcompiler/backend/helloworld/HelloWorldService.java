package com.marcompiler.backend.helloworld;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloWorldService {

    private final HelloWorldRepository helloWorldRepository;

    public HelloWorldService(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    public Optional<HelloWorld> getHelloWorldById(Long id) {
        if (id == null || id <= 0) return Optional.empty();

        return helloWorldRepository.findById(id);
    }

    public Optional<HelloWorld> getHelloWorldByHelloMessage(String helloMessage) {
        if (helloMessage == null || helloMessage.isEmpty()) return Optional.empty();

        return helloWorldRepository.findByHelloMessage(helloMessage);
    }
}
