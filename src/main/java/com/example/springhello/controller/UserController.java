package com.example.springhello.controller;

import com.example.springhello.domain.User;
import com.example.springhello.service.JdbcTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private JdbcTemplateService jdbcTemplateService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> userInfo(@PathVariable Long id) {
        User user = jdbcTemplateService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<String> usersInfo(@PathVariable Long id) {
        List<User> users = jdbcTemplateService.getUsers(id);
        StringBuilder output = new StringBuilder();
        for(User user : users) {
            output.append("id : ").append(user.getId());
            output.append(", name : ").append(user.getName());
            output.append(", age : ").append(user.getAge());
        }
        return ResponseEntity.ok(output.toString());
    }

    @PostMapping("/user")
    public ResponseEntity<String> upCount() {
        // user 정보를 request body에 담고 이를 받아 db에 넣으세요.
        // 리턴은 유저 아이디를 반환하세요.
        return null;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> userAll() {
        // 모든 유저를 반환하세요.
        return null;
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id) {
        // 유저 정보를 request body에 담고 해당 id의 정보를 수정하세요.
        User user = jdbcTemplateService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        // 유저를 제거하시고 해당 유저의 아이디를 반환하세요.
        return null;
    }
}


