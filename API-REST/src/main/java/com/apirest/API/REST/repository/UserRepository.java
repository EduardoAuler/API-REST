package com.apirest.API.REST.repository;

import com.apirest.API.REST.model.MaritalStatus;
import com.apirest.API.REST.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

//TESTANDO Query derivada e JPQL Query

    //acha usuario pelo final do nome
    List<User> findByNameEndingWithIgnoreCase(String finalLetra);

    @Query("SELECT u from User u WHERE u.name ILIKE %:finalLetra")
    List<User> usuariosTerminamComAlgumaLetra(String finalLetra);



    //usuarios maiores que x idade
    List<User> findByAgeGreaterThan(Integer age);

    @Query("SELECT u from User u WHERE u.age > :idade")
    List<User> usuariosMairesIdade(Integer idade);



    //usuarios criados depois de alguma data
    List<User> findByCreatedAtAfter(LocalDateTime localDateTime);

    @Query("SELECT u from User u WHERE u.createdAt > :localDateTime")
    List<User> usuariosDepoisDeAlgumaData(LocalDateTime localDateTime);



    //usuarios menores que x idade
    List<User> findByAgeLessThan(Integer age);

    @Query("SELECT u from User u WHERE u.age < :idade")
    List<User> usuariosMenoresIdade(Integer idade);



    //usuarios que são algum dos tipos de estado civil passado
    List<User> findByMaritalStatusIn(List<MaritalStatus> status);

    @Query("SELECT u from User u WHERE u.maritalStatus IN :status")
    List<User> usuariosEstadoCivil(List<MaritalStatus> status);



    //usuarios criados entre duas datas x
    List<User> findByCreatedAtBetween(LocalDateTime l1, LocalDateTime l2);

    @Query("SELECT u from User u WHERE u.createdAt BETWEEN :l1 AND :l2")
    List<User> usuariosEntreDuasDatas(LocalDateTime l1, LocalDateTime l2);



    List<String> findAllEmailsBy();

    @Query("SELECT u.email from User u")
    List<String> listaTodosEmail();


    List<User> findByMaritalStatus(MaritalStatus maritalStatus);
}
