package com.noob.notesapp.user.dao;

import com.noob.notesapp.user.model.User;
import com.noob.notesapp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
       userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }
    public Optional<User> getUserByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public Optional<User> getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

}
