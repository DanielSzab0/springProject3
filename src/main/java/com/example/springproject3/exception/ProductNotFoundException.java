package com.example.springproject3.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message) {
        super(message);       // apelam constructorul clasei parinte(RuntimeException)
    }
}
