package com.noob.notesapp.user.service;

import com.noob.notesapp.user.dao.UserDao;
import com.noob.notesapp.user.dto.ResponseStructure;
import com.noob.notesapp.user.exception.UserExistsException;
import com.noob.notesapp.user.exception.UserNameNotAvailableException;
import com.noob.notesapp.user.exception.UserNotFoundException;
import com.noob.notesapp.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    // add user
    public ResponseEntity<ResponseStructure<User>> addUser(User user) {
        isValidUser(user);
        userDao.addUser(user);
        ResponseStructure<User> response = new ResponseStructure<>(HttpStatus.CREATED,"user record added",user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    // check if the user is valid
    private void isValidUser(User user) {
        userDao.getUserByUserName(user.getUserName()).ifPresent(u -> {
            throw new UserNameNotAvailableException("user name "+ u.getUserName() +" is already in use!");
        });
        userDao.getUserByEmail(user.getEmail()).ifPresent( u -> {
            throw new UserExistsException("A user already exists with the email '" + u.getEmail() + "'");
        });
        userDao.getUserByPhone(user.getPhone()).ifPresent( u -> {
            throw new UserExistsException("A user already exists with the phone number '" + u.getPhone() + "'");
        });
    }

    public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
        Optional<User> optionalUser = userDao.getUserById(id);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found with the id " + id);
        }
        else{
            ResponseStructure<User> response = new ResponseStructure<>(HttpStatus.OK,"user found",optionalUser.get());
            return ResponseEntity.ok(response);
        }
    }

    public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
        List<User> users = userDao.getAllUser();
        Collections.sort(users,(u1,u2) -> Integer.compare(u1.getId(),u2.getId()));
        if(users.isEmpty()) {
            throw new UserNotFoundException("No user record available");
        }
        else {
            ResponseStructure<List<User>> response = new ResponseStructure<>(HttpStatus.OK,users.size() + " records found", users);
            return ResponseEntity.ok(response);
        }
    }

    public ResponseEntity<ResponseStructure<User>> getUserByUserNameAndPassword(String userName, String password) {
        Optional<User> optionalUser = userDao.getUserByUserNameAndPassword(userName,password);
        if(optionalUser.isPresent()) {
            ResponseStructure<User> response = new ResponseStructure<>(HttpStatus.OK,"User found",optionalUser.get());
            return ResponseEntity.ok(response);
        }
        else {
            throw new UserNotFoundException("Wrong credentials!");
        }
    }

    public ResponseEntity<ResponseStructure<User>> updateUserPassword(User user) {
        Optional<User> optionalUser = userDao.getUserByUserName(user.getUserName());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Wrong user name");
        }
        optionalUser.ifPresent(u -> {
            u.setPassword(user.getPassword());
            userDao.addUser(u);
        });
        ResponseStructure<User> response = new ResponseStructure<>(HttpStatus.OK, "password updated", optionalUser.get());
        return ResponseEntity.ok(response);
    }
}
