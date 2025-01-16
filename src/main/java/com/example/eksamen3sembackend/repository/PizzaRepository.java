package com.example.eksamen3sembackend.repository;

import com.example.eksamen3sembackend.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
}
