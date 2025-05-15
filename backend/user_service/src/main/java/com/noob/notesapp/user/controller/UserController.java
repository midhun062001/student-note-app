package com.noob.notesapp.user.controller;

import com.noob.notesapp.user.dto.ResponseStructure;
import com.noob.notesapp.user.dto.UserNameAndPasswordDto;
import com.noob.notesapp.user.dto.UserPasswordEmailDto;
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
    
    @PostMapping("/email")
    public ResponseEntity<ResponseStructure<User>> getUserByEmailAndPassword(@RequestBody UserPasswordEmailDto dto) {
    	return userService.getUserByEmailAndPassword(dto.email(), dto.password());
    }

    @PostMapping("/userName")
    public ResponseEntity<ResponseStructure<User>> getUserByUserNameAndPassword(@RequestBody UserNameAndPasswordDto dto) {
        return userService.getUserByUserNameAndPassword(dto.userName(), dto.password());
    }

    @PutMapping("/")
    public ResponseEntity<ResponseStructure<User>> updateUserPassword(@RequestBody User user) {
        return userService.updateUserPassword(user);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable String userName) {
        return userService.deleteUser(userName);
    }
}
