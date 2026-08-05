package com.marcompiler.backend.users;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public MyUserService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    @PreAuthorize("hasRole('demo:read:users')")
    public List<MyUser> getUsers() {
        return myUserRepository.findAll();
    }

    @PreAuthorize("hasRole('demo:read:users')")
    public Optional<MyUser> getUserById(Long id) {
        if (id == null || id <= 0) return Optional.empty();

        return myUserRepository.findById(id);
    }

    @PreAuthorize("hasRole('demo:read:users')")
    public Optional<MyUser> getUserBySurname(String surname) {
        if (surname == null || surname.isEmpty()) return Optional.empty();

        return myUserRepository.findBySurname(surname);
    }

    @PreAuthorize("hasRole('demo:read:users')")
    public Optional<MyUser> getUserBySub(String sub) {
        if (sub == null || sub.isEmpty()) return Optional.empty();

        return myUserRepository.findBySub(sub);
    }

    @PreAuthorize("hasRole('demo:write:users')")
    public MyUser saveUser(MyUser myUser) {
        return myUserRepository.save(myUser);
    }

    @PreAuthorize("hasRole('demo:read:users')")
    public boolean userExistsById(Long id) {
        return myUserRepository.existsById(id);
    }

    @PreAuthorize("hasRole('demo:write:users')")
    public void deleteUserById(Long id) {
        myUserRepository.deleteById(id);
    }
}
