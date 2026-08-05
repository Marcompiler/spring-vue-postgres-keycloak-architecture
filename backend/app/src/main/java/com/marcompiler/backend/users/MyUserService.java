package com.marcompiler.backend.users;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public MyUserService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    public List<MyUser> getUsers() {
        return myUserRepository.findAll();
    }

    public Optional<MyUser> getUserById(Long id) {
        if (id == null || id <= 0) return Optional.empty();

        return myUserRepository.findById(id);
    }

    public Optional<MyUser> getUserBySurname(String surname) {
        if (surname == null || surname.isEmpty()) return Optional.empty();

        return myUserRepository.findBySurname(surname);
    }

    public Optional<MyUser> getUserBySub(String sub) {
        if (sub == null || sub.isEmpty()) return Optional.empty();

        return myUserRepository.findBySub(sub);
    }

    public MyUser saveUser(MyUser myUser) {
        return myUserRepository.save(myUser);
    }

    public boolean userExistsById(Long id) {
        return myUserRepository.existsById(id);
    }

    public void deleteUserById(Long id) {
        myUserRepository.deleteById(id);
    }
}
