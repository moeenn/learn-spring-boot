package com.sandbox.api.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<UserEntity> findById(String id) {
        return userRepo.findById(id);
    }

    public List<UserEntity> list(int limit, int offset) {
        return userRepo.listPaginated(limit, offset);
    }

    public void addNew(String email, String name, UserRole role, String password) {
        var newUser = new UserEntity(email, name, role, password);
        userRepo.save(newUser);
    }

    public void updateUser(String id, String email, String name, UserRole role, String password) {
        var updatedUser = new UserEntity(id, email, name, role, password);
        userRepo.save(updatedUser);
    }

    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
 }
