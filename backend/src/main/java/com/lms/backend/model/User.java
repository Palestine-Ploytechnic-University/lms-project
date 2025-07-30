package com.lms.backend.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    public enum Role {
        ADMIN,
        INSTRUCTOR,
        STUDENT
    }

    public CharSequence getPassword() {
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    public void setPassword(String encode) {
        throw new UnsupportedOperationException("Unimplemented method 'setPassword'");
    }

    // Getters & Setters
}
