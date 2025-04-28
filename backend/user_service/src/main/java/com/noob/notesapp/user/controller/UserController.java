package com.noob.notesapp.user.controller;

import com.noob.notesapp.user.dto.ResponseStructure;
import com.noob.notesapp.user.model.User;
import com.noob.notesapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/")
    public ResponseEntity<ResponseStructure<User>> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
