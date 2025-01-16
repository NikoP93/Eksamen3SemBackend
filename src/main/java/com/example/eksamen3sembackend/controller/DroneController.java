package com.example.eksamen3sembackend.controller;

import com.example.eksamen3sembackend.model.Drone;
import com.example.eksamen3sembackend.model.Status;
import com.example.eksamen3sembackend.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DroneController {

    @Autowired
    private DroneService droneService;

    @GetMapping("/drones")
    public List<Drone> getAllDrones() {
      return droneService.getAllDrones();
    }

    @PostMapping("/drones/add")
    public ResponseEntity<Drone> addNewDrone(){
        return droneService.addDrone(new Drone());
    }

    @PostMapping("/drones/enable/{id}")
    public ResponseEntity<Drone> enableDrone(@PathVariable int id){
        return droneService.changeDroneStatus(id, Status.Operating);
    }

    @PostMapping("/drones/disable/{id}")
    public ResponseEntity<Drone> disableDrone(@PathVariable int id){
        return droneService.changeDroneStatus(id, Status.OutOfOperation);
    }

    @PostMapping("/drones/retire/{id}")
    public ResponseEntity<Drone> retireDrone(@PathVariable int id){
        return droneService.changeDroneStatus(id, Status.Retired);
    }
}


