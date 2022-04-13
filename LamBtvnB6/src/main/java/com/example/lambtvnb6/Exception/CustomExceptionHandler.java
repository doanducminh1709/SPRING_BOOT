package com.example.lambtvnb6.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice// Xu li cho dang restful API

public class CustomExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateException.class)
    public ErorResponse DuplicateExceptionHandler(DuplicateException ex , WebRequest rg){
        return new ErorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        //note :  trong đối tượng tảrả về mình sẽ trả về giá trị của cái trạng thái và một các message
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErorResponse NotFoundExceptionHandler(NotFoundException ex , WebRequest  rg){
        return new ErorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
