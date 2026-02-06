package com.apirest.API.REST.dto;

import com.apirest.API.REST.model.MaritalStatus;

import java.time.LocalDateTime;

public record UserDTO(Long id,
                      String name,
                      String email,
                      Integer age,
                      MaritalStatus maritalStatus,
                      LocalDateTime createdAt) {
}
