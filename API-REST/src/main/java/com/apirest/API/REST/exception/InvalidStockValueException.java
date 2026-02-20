package com.apirest.API.REST.exception;

public class InvalidStockValueException extends RuntimeException {
    public InvalidStockValueException(String message) {
        super(message);
    }
}
