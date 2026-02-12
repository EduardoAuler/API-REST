package com.apirest.API.REST.exception;

public class NameProductAlreadyExistsException extends RuntimeException {
    public NameProductAlreadyExistsException(String message) {
        super(message);
    }
}
