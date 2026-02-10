package com.apirest.API.REST.controller;


import com.apirest.API.REST.dto.UserDTO;
import com.apirest.API.REST.mapper.UserMapper;
import com.apirest.API.REST.model.User;
import com.apirest.API.REST.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> users = service.getAll().stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(users);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable long id){
        UserDTO user = mapper.toDTO(service.findUserById(id));

        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto){
        User user = mapper.toEntity(dto);
        User saved = service.createUser(user);
        UserDTO response = mapper.toDTO(saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        service.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}
