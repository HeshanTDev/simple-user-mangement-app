package com.heshant.usermanagement.advice;

import com.heshant.usermanagement.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleExceptions(MethodArgumentNotValidException exceptions) {
        Map<String, String> errorMap = new HashMap<>();
        exceptions.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> businessExceptionsHandler(UserNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error message :",exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

}
