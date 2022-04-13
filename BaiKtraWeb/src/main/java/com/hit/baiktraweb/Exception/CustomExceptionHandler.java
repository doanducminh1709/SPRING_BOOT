package com.hit.baiktraweb.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice// xử lí ngoại lệ trong ResFul API
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)//bat loi
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerNotFoundException(NotFoundException ex , WebRequest rb){
     return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
 }
    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerDuplicateException(DuplicateException ex , WebRequest rb){
     return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
 }
}
