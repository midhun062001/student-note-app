package com.noob.notesapp.user.service;

import com.noob.notesapp.user.dao.UserDao;
import com.noob.notesapp.user.dto.ResponseStructure;
import com.noob.notesapp.user.exception.UserExistsException;
import com.noob.notesapp.user.exception.UserNameNotAvailableException;
import com.noob.notesapp.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
