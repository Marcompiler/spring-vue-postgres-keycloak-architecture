package com.marcompiler.test_architecture_rest_jpa_oauth2.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long>  {
    Optional<MyUser> findBySub(String sub);

    Optional<MyUser> findBySurname(String surname);
}
