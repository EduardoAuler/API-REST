package com.apirest.API.REST.mapper;

import com.apirest.API.REST.dto.UserDTO;
import com.apirest.API.REST.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
   /*

        INICIALMENTE FIZ ASSIM, MAS ENFRENTEI ERROS DE COMPILAR, ELE NAO TAVA RECONHECENDO O MAPPER COMO COMPONENT, ENT FIZ SEM ELE

   private final ObjectMapper objectMapper;

    public UserMapper(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public User toEntity(UserDTO dto){
        return objectMapper.convertValue(dto, User.class);
    }

    public UserDTO toDTO(User user){
        return objectMapper.convertValue(user, UserDTO.class);
    }*/


    public User toEntity(UserDTO dto){
        return new User(dto.id(), dto.name(), dto.email(), dto.age(),
                dto.maritalStatus(), dto.createdAt());
    }

    public UserDTO toDTO(User user){
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getAge(),
                user.getMaritalStatus(), user.getCreatedAt());
    }

}
