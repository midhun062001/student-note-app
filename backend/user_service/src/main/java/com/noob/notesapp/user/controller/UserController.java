package com.noob.notesapp.user.controller;

import com.noob.notesapp.user.dto.ResponseStructure;
import com.noob.notesapp.user.model.User;
import com.noob.notesapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/")
    public ResponseEntity<ResponseStructure<User>> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/")
    public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/")
    public ResponseEntity<ResponseStructure<User>> getUserByUserNameAndPassword(@PathVariable String userName, @PathVariable String password) {
        return userService.getUserByUserNameAndPassword(userName,password);
    }
}
