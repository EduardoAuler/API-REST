package com.apirest.API.REST.controller;


import com.apirest.API.REST.dto.UserDTO;
import com.apirest.API.REST.mapper.UserMapper;
import com.apirest.API.REST.model.User;
import com.apirest.API.REST.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/users") pode ser assim caso todos request usarem mesma url
public class UserController {//fala com DTO

    private final UserService service;
    private final UserMapper mapper;

    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/users")
    public List<UserDTO> findAll(){
        return service.getAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO dto){
        User user = mapper.toEntity(dto);
        User saved = service.createUser(user);

        return mapper.toDTO(saved);
    }
}
