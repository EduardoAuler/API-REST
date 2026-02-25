package com.apirest.API.REST.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ResponseError> emailAlreadyExistsHandler(EmailAlreadyExistsException ex){
        return buildErrorResponse(ex.getMessage(), HttpStatus.CONFLICT);
    }


    @ExceptionHandler(InvalidStockValueException.class)
    public ResponseEntity<ResponseError> invalidStockValueHandler(InvalidStockValueException ex){
        return buildErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NameProductAlreadyExistsException.class)
    public ResponseEntity<ResponseError> nameProductAlreadyExists(NameProductAlreadyExistsException ex){
        return buildErrorResponse(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseError> productNotFoundHandler(ProductNotFoundException ex){
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseError> userNotFoundHandler(UserNotFoundException ex){
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<ResponseError> buildErrorResponse(
            String message, HttpStatus status) {

        ResponseError error = new ResponseError(
                message,
                status,
                LocalDateTime.now()
        );

        return ResponseEntity.status(status).body(error);
    }
}
