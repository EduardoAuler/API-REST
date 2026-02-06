package com.apirest.API.REST.mapper;

import com.apirest.API.REST.dto.UserDTO;
import com.apirest.API.REST.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ObjectMapper objectMapper;

    public UserMapper(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public User toEntity(UserDTO dto){
        return objectMapper.convertValue(dto, User.class);
    }

    public UserDTO toDTO(User user){
        return objectMapper.convertValue(user, UserDTO.class);
    }

}
