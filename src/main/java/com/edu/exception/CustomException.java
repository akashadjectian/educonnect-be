package com.edu.exception;

public class CustomException  extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}