package com.marcompiler.backend.users;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class MyUserServiceTest {
    @Mock
    private MyUserRepository repository;

    @InjectMocks
    private MyUserService service;

    @Test
    void testCreateUser() {
        String sub = UUID.randomUUID().toString();
        String surname = "test";

        MyUser myUser = new MyUser(sub, surname);

        // Tells Mockito to returns 'myUser' on the 'repository.save' call
        when(repository.save(Mockito.any())).thenReturn(myUser);

        MyUser result = service.saveUser(myUser);

        assertEquals(myUser, result);
    }

    @Test
    void testGetUserById() {
        Long id = 1L;
        String sub = UUID.randomUUID().toString();
        String surname = "test";

        MyUser myUser = new MyUser(sub, surname);
        myUser.id = id;

        when(repository.findById(id)).thenReturn(Optional.of(myUser));

        MyUser result = service.getUserById(id).orElseThrow();

        assertEquals(myUser, result);
    }

    @Test
    void testGetUserBySurname() {
        String sub = UUID.randomUUID().toString();
        String surname = "test";

        MyUser myUser = new MyUser(sub, surname);

        when(repository.findBySurname(surname)).thenReturn(Optional.of(myUser));

        MyUser result = service.getUserBySurname(surname).orElseThrow();

        assertEquals(myUser, result);
    }

    @Test
    void testGetUserBySub() {
        String sub = UUID.randomUUID().toString();
        String surname = "test";

        MyUser myUser = new MyUser(sub, surname);

        when(repository.findBySub(sub)).thenReturn(Optional.of(myUser));

        MyUser result = service.getUserBySub(sub).orElseThrow();

        assertEquals(myUser, result);
    }
}
