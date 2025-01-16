package com.example.eksamen3sembackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int droneID;
    private int serialuuid;
    private Status status;

    @OneToMany(mappedBy = "drone")
    @JsonBackReference
    Set<Delivery> deliveries  = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="stationidfk",referencedColumnName = "stationID")
    private Station station;

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public int getDroneID() {
        return droneID;
    }

    public void setDroneID(int droneID) {
        this.droneID = droneID;
    }

    public int getSerialuuid() {
        return serialuuid;
    }

    public void setSerialuuid(int serialuuid) {
        this.serialuuid = serialuuid;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
