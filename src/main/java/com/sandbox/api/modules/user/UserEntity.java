package com.sandbox.api.modules.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    public UUID id;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public UserRole role;

    @Column(nullable = false)
    public String password;

    @Column(nullable = false, name = "created_at")
    public LocalDateTime createdAt;

    @Column(nullable = true, name = "deleted_at")
    public LocalDateTime deletedAt;

    public UserEntity() {
    }

    public UserEntity(UUID id, String email, String name, UserRole role, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.deletedAt = null;
    }

    public UserEntity(String email, String name, UserRole role, String password) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.name = name;
        this.role = role;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.deletedAt = null;
    }
}
