package com.heshant.usermanagement.controller;

import com.heshant.usermanagement.dto.request.UserCreateRequestDTO;
import com.heshant.usermanagement.dto.response.UserResponseDTO;
import com.heshant.usermanagement.exception.UserNotFoundException;
import com.heshant.usermanagement.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("user-management/users")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(userServiceImpl.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable long id) throws UserNotFoundException {
        return ResponseEntity.ok(userServiceImpl.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody @Valid UserCreateRequestDTO user) {
        UserResponseDTO savedUser = userServiceImpl.addUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable long id, @Valid @RequestBody UserCreateRequestDTO user) {
        UserResponseDTO savedUser = userServiceImpl.updateUser(id, user);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> deleteUserById(@PathVariable long id) {
        userServiceImpl.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
