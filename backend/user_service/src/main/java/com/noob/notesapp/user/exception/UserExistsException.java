package com.noob.notesapp.user.exception;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String message) {
        super(message);
    }
    public UserExistsException() {
        this("user exists with the provided credentials");
    }
}
