package com.marcompiler.backend.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class HelloWorldRepositoryTest {

    @Autowired
    private HelloWorldRepository helloWorldRepository;

    @Test
    void testSaveHelloWorld() {
        HelloWorld helloWorld = new HelloWorld("Hello Test");
        HelloWorld saved = helloWorldRepository.save(helloWorld);

        assertNotNull(saved.getId());
        assertEquals("Hello Test", saved.getHelloMessage());
    }

    @Test
    void testFindByHelloMessage() {
        helloWorldRepository.save(new HelloWorld("Hello World"));
        var result = helloWorldRepository.findByHelloMessage("Hello World");

        assertTrue(result.isPresent());
    }

    @Test
    void testFindAll() {
        helloWorldRepository.save(new HelloWorld("Message 1"));
        helloWorldRepository.save(new HelloWorld("Message 2"));

        var all = helloWorldRepository.findAll();
        assertEquals(2, all.size());
    }
}