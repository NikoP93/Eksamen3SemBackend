package com.example.eksamen3sembackend;

import com.example.eksamen3sembackend.model.Delivery;
import com.example.eksamen3sembackend.service.DeliveryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class DeliveryServiceTest {

    @Autowired
    DeliveryService deliveryService;

    @Test
    public void getAllDeliveriesNotDeliveredTest(){

        //Act
        List<Delivery> deliveries = deliveryService.getAllDeliveriesNotDelivered();
        int expectedSize = 3;
        int actualSize = deliveries.size();

        //Assert
        assertNotNull(deliveries);
        assertEquals(expectedSize,actualSize);
    }

    @Test
    public void getAllDeliveriesWithoutADroneTest(){

        List<Delivery> deliveries = deliveryService.getAllDeliveriesWithoutADrone();

        int expectedSize = 1;
        int actualSize = deliveries.size();

        assertNotNull(deliveries);
        assertEquals(expectedSize,actualSize);
    }

    @Test
    public void addDeliveryTest(){

        Delivery delivery1 = new Delivery();
        delivery1.setAdress("Jensgade 1");
        delivery1.setExpectedDeliveryTime(LocalDateTime.now().plusMinutes(30));
        ResponseEntity<Delivery> savedDelivery = deliveryService.addDelivery(delivery1);

        assertNotNull(savedDelivery);
        assertNotNull(savedDelivery.getBody().getDeliveryID());


    }
}
