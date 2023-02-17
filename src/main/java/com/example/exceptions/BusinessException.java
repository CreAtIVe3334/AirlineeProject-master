package com.example.exceptions;

public class BusinessException extends RuntimeException{
    String message;

    public BusinessException(String message){
        super(message);
        this.message=message;
    }
}
