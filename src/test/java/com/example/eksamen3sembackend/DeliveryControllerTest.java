package com.example.eksamen3sembackend;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class DeliveryControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    void getAllDeliveriesNotDelivered() throws Exception {
        mockMvc.perform(get("/deliveries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3));
    }


    @Test
    void getAllDeliveriesWithoutADrone() throws Exception {
        mockMvc.perform(get("/deliveries/queue"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1));
    }


    @Test
    void addDelivery() throws Exception {
        String newDeliveryJson = """
                    {
                        "adress": "Nyrnberggade 12",
                        "pizza": {
                            "pizzaID": 1
                        }
                    }
                """;

        mockMvc.perform(post("/deliveries/add")
                        .contentType("application/json") // Specify content type as JSON
                        .content(newDeliveryJson))      // Provide the JSON body
                .andExpect(status().isCreated());
    }


    @Test
    void scheduleDelivery() throws Exception {
        int deliveryId = 1;

        mockMvc.perform(post("/deliveries/schedule/" + deliveryId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.drone").isNotEmpty())
                .andExpect(jsonPath("$.deliveryID").value(deliveryId));
    }


    @Test
    void finishDelivery() throws Exception {
        int deliveryId = 2;

        mockMvc.perform(post("/deliveries/finish/" + deliveryId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.actualDeliveryTime").isNotEmpty())
                .andExpect(jsonPath("$.deliveryID").value(deliveryId));
    }



}
