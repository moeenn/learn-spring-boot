package com.sandbox.api.modules.user;

public record UserDTO(
        String id,
        String email,
        String name,
        String createdAt
) {

    public static UserDTO fromEntity(UserEntity e) {
        return new UserDTO(
                e.id,
                e.email,
                e.name,
                e.createdAt.toString()
        );
    }

}
