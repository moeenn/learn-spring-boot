package com.sandbox.api.modules.user;

import com.sandbox.api.common.dto.PaginatedResponse;
import com.sandbox.api.modules.user.dto.UserDTO;
import com.sandbox.api.modules.user.dto.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        Optional<UserEntity> user = userService.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        var res = UserDTO.fromEntity(user.get());
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<PaginatedResponse<UserDTO>> listUsers(
            @RequestParam(required=false) Integer limit,
            @RequestParam(required=false) Integer offset
            ) {

        int qLimit = limit == null ? 10 : limit;
        int qOffset = offset == null ? 0 : offset;

        List<UserEntity> users = userService.list(qLimit, qOffset);
        List<UserDTO> userRes = users.stream().map(UserDTO::fromEntity).toList();
        PaginatedResponse<UserDTO> res = new PaginatedResponse<>(userRes, users.size(), qLimit, qOffset);
        return ResponseEntity.ok(res);
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UserUpdateRequest req) throws Exception {
        req.validate();
        userService.addNew(req.email,req.name, req.role, req.password);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserUpdateRequest req) throws Exception {
        req.validate();
        userService.updateUser(id, req.email,req.name, req.role, req.password);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
