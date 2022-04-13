package com.example.chuabtvnb7.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomResponse {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErorResponse NotFoundExceptionHandler(NotFoundException ex , WebRequest reg){
      return new ErorResponse(HttpStatus.NOT_FOUND.value() , ex.getMessage());
  }
    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErorResponse DuplicateExceptionHandler(NotFoundException ex , WebRequest reg){
        return new ErorResponse(HttpStatus.BAD_REQUEST.value() , ex.getMessage());
    }
}
