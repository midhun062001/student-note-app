package com.noob.notesapp.user.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException() {
        this("User not found with the given credentials");
    }
}
