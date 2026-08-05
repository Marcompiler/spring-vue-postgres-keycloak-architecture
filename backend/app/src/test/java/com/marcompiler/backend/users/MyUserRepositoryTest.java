package com.marcompiler.backend.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class MyUserRepositoryTest {

    @Autowired
    private MyUserRepository userRepository;

    private MyUser testUser;

    @BeforeEach
    void setUp() {
        testUser = new MyUser("sub-123", "TestUser");
    }

    @Test
    void testSaveUser() {
        MyUser saved = userRepository.save(testUser);
        assertNotNull(saved.getId());
        assertEquals("sub-123", saved.getSub());
    }

    @Test
    void testFindUserBySub() {
        userRepository.save(testUser);
        var result = userRepository.findBySub("sub-123");
        assertTrue(result.isPresent());
        assertEquals("TestUser", result.get().getSurname());
    }

    @Test
    void testFindUserBySurname() {
        userRepository.save(testUser);
        var result = userRepository.findBySurname("TestUser");
        assertTrue(result.isPresent());
        assertEquals("sub-123", result.get().getSub());
    }

    @Test
    void testFindUserByIdNotFound() {
        var result = userRepository.findById(999L);
        assertFalse(result.isPresent());
    }

    @Test
    void testDeleteUser() {
        MyUser saved = userRepository.save(testUser);
        userRepository.deleteById(saved.getId());
        assertFalse(userRepository.existsById(saved.getId()));
    }

    @Test
    void testUniqueConstraintOnSub() {
        userRepository.save(testUser);
        MyUser duplicate = new MyUser("sub-123", "AnotherUser");

        assertThrows(Exception.class, () -> {
            userRepository.save(duplicate);
            userRepository.flush(); // Force la vérification de la contrainte
        });
    }
}