package com.example.btvnb7.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomResponse {
    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorException duplicateExceptionHandler(DuplicateException ex , WebRequest reg){
        return new ErrorException(HttpStatus.BAD_REQUEST.value() , ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorException errorExceptionHandler(NotFoundException ex , WebRequest reg){
        return new ErrorException(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
