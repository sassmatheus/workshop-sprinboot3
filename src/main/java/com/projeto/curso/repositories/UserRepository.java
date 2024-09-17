package com.projeto.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
