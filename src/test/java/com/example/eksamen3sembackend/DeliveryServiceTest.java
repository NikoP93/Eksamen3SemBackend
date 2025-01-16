package com.example.eksamen3sembackend;

import com.example.eksamen3sembackend.model.Delivery;
import com.example.eksamen3sembackend.service.DeliveryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
}
