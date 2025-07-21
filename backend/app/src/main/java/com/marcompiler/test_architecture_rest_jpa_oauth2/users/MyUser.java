package com.marcompiler.test_architecture_rest_jpa_oauth2.users;

import com.marcompiler.test_architecture_rest_jpa_oauth2.common.BaseJpaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "USERS")
public class MyUser extends BaseJpaEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String sub;

    @Column(nullable = false, unique = true)
    String surname;

    @Override
    public Long getId() {
        return 0L;
    }

    private MyUser() {}

    public MyUser(String sub, String surname) {
        this.sub = sub;
        this.surname = surname;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
