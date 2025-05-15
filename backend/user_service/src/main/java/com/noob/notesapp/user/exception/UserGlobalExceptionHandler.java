package com.noob.notesapp.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserNameNotAvailableException.class)
    public ResponseEntity<String> handleUserNameNotAvailableException() {
        return ResponseEntity.internalServerError().body("User not found!");
    }
    public ResponseEntity<String> handleUserExistsException(UserExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
