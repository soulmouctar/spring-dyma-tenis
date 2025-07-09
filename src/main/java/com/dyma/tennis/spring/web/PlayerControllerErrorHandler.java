package com.dyma.tennis.spring.web;

import com.dyma.tennis.spring.Error;
import com.dyma.tennis.spring.exceptions.PlayerNotFounfException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class PlayerControllerErrorHandler {

    @ExceptionHandler(PlayerNotFounfException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handlePlayerNotFoundException(PlayerNotFounfException exception) {
        return new Error(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = ( error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
