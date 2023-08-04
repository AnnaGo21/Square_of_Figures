package com.example.square.exception;

public class InvalidDimensionsException extends RuntimeException {
    public InvalidDimensionsException(String message) {
        super(message);
    }
}