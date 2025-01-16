package com.example.eksamen3sembackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationID;
    private double latitude;
    private double longitude;

    @OneToMany(mappedBy = "station")
    @JsonBackReference
    private Set<Drone> droneSet  = new HashSet<>();

    public Set<Drone> getDroneSet() {
        return droneSet;
    }

    public void setDroneSet(Set<Drone> droneSet) {
        this.droneSet = droneSet;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }
}
