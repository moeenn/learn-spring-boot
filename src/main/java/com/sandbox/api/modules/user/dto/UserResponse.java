package com.sandbox.api.modules.user.dto;

import com.sandbox.api.modules.user.UserEntity;

public record UserResponse(
        String id,
        String email,
        String name,
        String createdAt) {

    public static UserResponse fromEntity(UserEntity e) {
        return new UserResponse(
                e.id.toString(),
                e.email,
                e.name,
                e.createdAt.toString());
    }

}
