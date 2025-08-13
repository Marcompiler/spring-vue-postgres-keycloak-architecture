package com.marcompiler.backend.helloworld;

import com.marcompiler.backend.common.BaseJpaEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "HELLOWORLDS")
public class HelloWorld extends BaseJpaEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String helloMessage;

    public HelloWorld() {}

    public HelloWorld(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }
}
