package com.sandbox.api.modules.user.dto;

import com.sandbox.api.modules.user.UserRole;

public class UserUpdateRequest {
    public String email;
    public String name;
    public UserRole role;
    public String password;
    public String confirmPassword;

    public UserUpdateRequest() {}

    public UserUpdateRequest(String email, String name, UserRole role, String password, String confirmPassword) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public void validate() throws Exception {
        if (this.role == UserRole.ADMIN) {
            throw new Exception("cannot create admin accounts over API");
        }

        if (!this.password.equals(this.confirmPassword)) {
            throw new Exception("password confirmation failed");
        }
    }
}
