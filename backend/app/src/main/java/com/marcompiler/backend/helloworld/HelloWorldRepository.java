package com.marcompiler.backend.helloworld;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HelloWorldRepository extends JpaRepository<HelloWorld, Long> {
    Optional<HelloWorld> findByHelloMessage(String helloMessage);
}
