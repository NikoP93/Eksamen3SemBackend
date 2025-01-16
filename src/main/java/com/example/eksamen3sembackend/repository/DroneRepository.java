package com.example.eksamen3sembackend.repository;

import com.example.eksamen3sembackend.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DroneRepository extends JpaRepository<Drone, Integer> {

    @Query(value = "SELECT * FROM drone WHERE status = 0 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Drone findRandomDrone();
}
