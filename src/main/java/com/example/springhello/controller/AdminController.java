package com.example.springhello.controller;

import com.example.springhello.dto.*;
import com.example.springhello.entity.User;
import com.example.springhello.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> userInfo(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    public ResponseEntity<Long> userAdd(@RequestBody User user) {
        return ResponseEntity.ok(userService.insertUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> userAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/user")
    public ResponseEntity<UserResponse> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUserById(user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
