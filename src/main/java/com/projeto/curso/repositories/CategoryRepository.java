package com.projeto.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
