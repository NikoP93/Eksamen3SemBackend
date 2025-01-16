package com.example.eksamen3sembackend.service;

import com.example.eksamen3sembackend.model.Drone;
import com.example.eksamen3sembackend.model.Station;
import com.example.eksamen3sembackend.model.Status;
import com.example.eksamen3sembackend.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private StationService stationService;



    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    public ResponseEntity<Drone> addDrone(Drone drone) {
        Station stationWithFewestDrone = stationService.findStationWithFewestDrones();
        drone.setSerialuuid(generateRandomNumber());
        drone.setStatus(Status.Operating);
        drone.setStation(stationWithFewestDrone);
        Drone savedDrone = droneRepository.save(drone);
        return new ResponseEntity<>(savedDrone, HttpStatus.CREATED);
    }

    public ResponseEntity<Drone> changeDroneStatus(int droneID, Status status) {
    Optional<Drone> droneOptional = droneRepository.findById(droneID);
    if (droneOptional.isPresent()) {
        Drone drone = droneOptional.get();
        drone.setStatus(status);
        droneRepository.save(drone);
        return new ResponseEntity<>(drone, HttpStatus.OK);
    }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //-------------------------------Hjælpe metoder-----------------------------------------
    public int generateRandomNumber(){
        Random rand = new Random();
        return 1000 + rand.nextInt(9000);
    }


    //Der skal checkes om alle droner virker og hvis ikke, kaste en exception.
    public Drone getRandomDrone(){
        return droneRepository.findRandomDrone();
    }


}
