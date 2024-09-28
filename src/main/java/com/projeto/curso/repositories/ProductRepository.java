package com.projeto.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
