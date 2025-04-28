package com.noob.notesapp.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserGlobalExceptionHandler {
    public ResponseEntity<String> handleUserNameNotAvailableException(UserNameNotAvailableException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
    public ResponseEntity<String> handleUserExistsException(UserExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
