package com.sandbox.api.modules.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    public String id;

    @Column(nullable=false, unique=true)
    public String email;

    @Column(nullable=false)
    public String name;

    @Column(nullable=false)
    public String password;

    @Column(nullable=false, name="created_at")
    public LocalDateTime createdAt;

    @Column(nullable=true, name="deleted_at")
    public LocalDateTime deletedAt;

    public UserEntity() {}

    public UserEntity(String id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.deletedAt = null;
    }

    public UserEntity(String email, String name, String password) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.deletedAt = null;
    }
}
