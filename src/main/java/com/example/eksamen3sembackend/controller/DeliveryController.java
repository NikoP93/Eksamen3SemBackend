package com.example.eksamen3sembackend.controller;

import com.example.eksamen3sembackend.model.Delivery;
import com.example.eksamen3sembackend.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/deliveries")
    public List<Delivery> getAllDeliveriesNotDelivered(){
        return deliveryService.getAllDeliveriesNotDelivered();
    }

    @GetMapping("/deliveries/queue")
    public List<Delivery> getAllDeliveriesWithoutADrone(){
        return deliveryService.getAllDeliveriesWithoutADrone();
    }

    @PostMapping("/deliveries/add")
    public ResponseEntity<Delivery> addDelivery(@RequestBody Delivery delivery){
        return deliveryService.addDelivery(delivery);
    }

    @PostMapping("/deliveries/schedule/{id}")
    public ResponseEntity<Delivery> scheduleDelivery(@PathVariable int id){
        return deliveryService.scheduleDelivery(id);
    }

    @PostMapping("/deliveries/finish/{id}")
    public ResponseEntity<Delivery> finishDelivery(@PathVariable int id){
        return deliveryService.finishDelivery(id);
    }
}
