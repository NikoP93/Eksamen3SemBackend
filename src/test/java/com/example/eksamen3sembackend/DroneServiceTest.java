package com.example.eksamen3sembackend;

import com.example.eksamen3sembackend.model.Drone;
import com.example.eksamen3sembackend.service.DroneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class DroneServiceTest {

    @Autowired
    private DroneService droneService;

    @Test
    public void getAllDrones(){
        //Act
        List<Drone> droneList = droneService.getAllDrones();
        int expectedSize = 3;
        int actualSize = droneList.size();

        //Assert
        assertNotNull(droneList);
        assertEquals(expectedSize,actualSize);

    }

    @Test
    public void addDrone(){
        //Act
    Drone drone = new Drone();
    ResponseEntity<Drone> response = droneService.addDrone(drone);

    //Assert
    assertEquals(HttpStatus.CREATED,response.getStatusCode());
    assertNotNull(response.getBody());

    }



}
