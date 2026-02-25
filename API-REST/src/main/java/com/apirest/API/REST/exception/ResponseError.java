package com.apirest.API.REST.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseError(String mensage,
                            HttpStatus httpStatus,
                            LocalDateTime local) {
}
