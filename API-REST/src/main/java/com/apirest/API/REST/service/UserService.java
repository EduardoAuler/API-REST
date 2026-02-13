package com.apirest.API.REST.service;

import com.apirest.API.REST.exception.EmailAlreadyExistsException;
import com.apirest.API.REST.exception.UserNotFoundException;
import com.apirest.API.REST.model.User;
import com.apirest.API.REST.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service//fala com entity
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user){
        if (repository.existsByEmail(user.getEmail()))
            throw new EmailAlreadyExistsException("Email já cadastrado");
        return repository.save(user);
    }

    public User findUserById(Long id){
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
    }

    public User findUserByEmail(String email){
        return repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
    }


    public List<User> getAll(){
        return repository.findAll();
    }

    public void deleteUser(Long id){
        if (!repository.existsById(id)) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        repository.deleteById(id);
    }

    @Transactional//só vai fazer essa operação se conseguir fazer isso com todos, caso uma troca de errado ele cancela a operação
    public User updateUser(Long id,User dados){
        User user = findUserById(id);
        if (!user.getEmail().equals(dados.getEmail()) &&
                repository.existsByEmail(dados.getEmail())) {
            throw new EmailAlreadyExistsException("Email já cadastrado");
        }
        user.setAge(dados.getAge());
        user.setName(dados.getName());
        user.setMaritalStatus(dados.getMaritalStatus());

        return repository.save(user);
    }


    public List<String> getAllEmail() {
        return repository.listaTodosEmail();
    }

    public List<User> getUserMaioresIdade(Integer age){
        return repository.findByAgeGreaterThan(age);
    }

    public List<User> getUserAfterDate(LocalDateTime localDateTime){
        List<User> users = repository.findByCreatedAtAfter(localDateTime);

        if (users.isEmpty()) throw new UserNotFoundException("Nenhum usuário criado após essa data");

        return users;
    }

}
