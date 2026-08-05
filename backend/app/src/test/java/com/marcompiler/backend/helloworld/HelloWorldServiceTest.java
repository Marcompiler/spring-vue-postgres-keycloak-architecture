package com.marcompiler.backend.helloworld;

import com.marcompiler.backend.users.MyUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class HelloWorldServiceTest {
    @Mock
    private HelloWorldRepository repository;

    @InjectMocks
    private HelloWorldService service;

    @Test
    void testGetHelloWorldById() {
        Long id = 1L;

        HelloWorld helloWorld = new HelloWorld("test");
        helloWorld.id = id;

        when(repository.findById(id)).thenReturn(Optional.of(helloWorld));

        HelloWorld result = service.getHelloWorldById(id).orElseThrow();

        assertEquals(helloWorld, result);
    }

    @Test
    void testGetHelloWorldByHelloMessage() {
        String helloMessage = "test";

        HelloWorld helloWorld = new HelloWorld(helloMessage);

        when(repository.findByHelloMessage(helloMessage)).thenReturn(Optional.of(helloWorld));

        HelloWorld result = service.getHelloWorldByHelloMessage(helloMessage).orElseThrow();

        assertEquals(helloWorld, result);
    }
}
