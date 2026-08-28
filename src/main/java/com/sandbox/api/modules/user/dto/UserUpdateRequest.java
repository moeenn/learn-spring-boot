package com.sandbox.api.modules.user.dto;

import org.hibernate.validator.constraints.Length;
import com.sandbox.api.modules.user.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserUpdateRequest {
    @NotBlank
    @Email
    public String email;

    @NotBlank
    @Min(3)
    public String name;

    @NotBlank
    public UserRole role;

    @Length(min = 8)
    public String password;

    @Length(min = 8)
    public String confirmPassword;

    public UserUpdateRequest() {
    }

    public UserUpdateRequest(String email, String name, UserRole role, String password, String confirmPassword) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
