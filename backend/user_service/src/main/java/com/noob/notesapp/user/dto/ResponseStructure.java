package com.noob.notesapp.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ResponseStructure <T>{
    private HttpStatus status;
    private String message;
    private T data;
}
