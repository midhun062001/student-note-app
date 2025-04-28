package com.noob.notesapp.user.exception;

public class UserNameNotAvailableException extends RuntimeException{
    public UserNameNotAvailableException(String message) {
        super(message);
    }
    public UserNameNotAvailableException() {
        this("user name in use");
    }
}
