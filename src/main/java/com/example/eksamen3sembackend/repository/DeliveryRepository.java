package com.example.eksamen3sembackend.repository;

import com.example.eksamen3sembackend.model.Delivery;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    List<Delivery> findAllByActualDeliveryTimeIsNull(Sort sort);

    List<Delivery> findAllByDroneIsNull();
}
