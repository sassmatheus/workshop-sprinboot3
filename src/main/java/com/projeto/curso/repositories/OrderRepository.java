package com.projeto.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
