package com.example.eksamen3sembackend.service;

import com.example.eksamen3sembackend.model.Delivery;
import com.example.eksamen3sembackend.model.Drone;
import com.example.eksamen3sembackend.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DroneService droneService;

    public List<Delivery> getAllDeliveriesNotDelivered() {
        return deliveryRepository.findAllByActualDeliveryTimeIsNull();
    }

    public List<Delivery> getAllDeliveriesWithoutADrone(){
        return deliveryRepository.findAllByDroneIsNull();
    }

    public ResponseEntity<Delivery> addDelivery(Delivery delivery) {
        Delivery savedDelivery = deliveryRepository.save(delivery);
        return new ResponseEntity<>(savedDelivery, HttpStatus.CREATED);
    }

    public ResponseEntity<Delivery> scheduleDelivery(int deliveryID) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryID);
        if (optionalDelivery.isPresent()) {
            Delivery delivery = optionalDelivery.get();
            if (delivery.getDrone() == null){
                Drone randomDrone = droneService.getRandomDrone();
                delivery.setDrone(randomDrone);
                deliveryRepository.save(delivery);
                return new ResponseEntity<>(delivery, HttpStatus.OK);
            }else{
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Drone is already attached");
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery does not exist");
    }

    public ResponseEntity<Delivery> finishDelivery(int deliveryID) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryID);
        if (optionalDelivery.isPresent()) {
            Delivery delivery = optionalDelivery.get();
            if (delivery.getDrone() == null){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "No drone is attached");
            }else{
                delivery.setActualDeliveryTime(LocalDateTime.MIN);
                return new ResponseEntity<>(delivery, HttpStatus.OK);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery does not exist");
    }
}
