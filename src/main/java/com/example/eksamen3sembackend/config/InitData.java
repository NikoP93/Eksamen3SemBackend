package com.example.eksamen3sembackend.config;

import com.example.eksamen3sembackend.model.*;
import com.example.eksamen3sembackend.repository.DeliveryRepository;
import com.example.eksamen3sembackend.repository.DroneRepository;
import com.example.eksamen3sembackend.repository.PizzaRepository;
import com.example.eksamen3sembackend.repository.StationRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    StationRepository stationRepository;

    @Autowired
    DroneRepository droneRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public void run(String... args) throws Exception {


        Station station1 = new Station();
        station1.setLatitude(55.41);
        station1.setLongitude(12.34);
        stationRepository.save(station1);


        Station station2 = new Station();
        station2.setLatitude(55.67);
        station2.setLongitude(12.56);
        stationRepository.save(station2);

        Station station3 = new Station();
        station3.setLatitude(55.64);
        station3.setLongitude(12.61);
        stationRepository.save(station3);

        Pizza pizza1 = new Pizza();
        pizza1.setTitle("Margherita");
        pizza1.setPrice(90);
        pizzaRepository.save(pizza1);

        Pizza pizza2 = new Pizza();
        pizza2.setTitle("Pepperoni");
        pizza2.setPrice(100);
        pizzaRepository.save(pizza2);

        Pizza pizza3 = new Pizza();
        pizza3.setTitle("Hawaiian");
        pizza3.setPrice(105);
        pizzaRepository.save(pizza3);

        Pizza pizza4 = new Pizza();
        pizza4.setTitle("Vegetarian");
        pizza4.setPrice(95);
        pizzaRepository.save(pizza4);

        Pizza pizza5 = new Pizza();
        pizza5.setTitle("Four Cheese");
        pizza5.setPrice(110);
        pizzaRepository.save(pizza5);

        Drone drone1 = new Drone();
        drone1.setSerialuuid(1234);
        drone1.setStatus(Status.Operating);
        drone1.setStation(station1);
        droneRepository.save(drone1);


        Drone drone2 = new Drone();
        drone2.setSerialuuid(5678);
        drone2.setStatus(Status.Operating);
        drone2.setStation(station2);
        droneRepository.save(drone2);

        Drone drone3 = new Drone();
        drone3.setSerialuuid(9999);
        drone3.setStatus(Status.OutOfOperation);
        drone3.setStation(station1);
        droneRepository.save(drone3);

        Delivery delivery1 = new Delivery();
        delivery1.setAdress("Jensgade 1");
        delivery1.setPizza(pizza1);
        delivery1.setExpectedDeliveryTime(LocalDateTime.now().plusMinutes(30));
        deliveryRepository.save(delivery1);

        Delivery delivery2 = new Delivery();
        delivery2.setAdress("Kurtgade 3");
        delivery2.setPizza(pizza2);
        delivery2.setExpectedDeliveryTime(LocalDateTime.now().plusMinutes(30));
        delivery2.setDrone(drone1);
        delivery2.setActualDeliveryTime(LocalDateTime.now().plusMinutes(40));
        deliveryRepository.save(delivery2);

        Delivery delivery3 = new Delivery();
        delivery3.setAdress("Kurtgade 3");
        delivery3.setPizza(pizza2);
        delivery3.setDrone(drone1);
        deliveryRepository.save(delivery3);


    }


}
