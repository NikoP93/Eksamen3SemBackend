package com.example.eksamen3sembackend.service;

import com.example.eksamen3sembackend.model.Station;
import com.example.eksamen3sembackend.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public Station findStationWithFewestDrones() {
        List<Station> stationList = stationRepository.findAll();
        if (stationList.isEmpty()) {
            throw new RuntimeException("Der er ingen stationer");
        } else {
            Station stationWithFewestDrones = stationList.get(0);
            int fewestDrones = stationWithFewestDrones.getDroneSet().size();

            for (Station station : stationList) {
                int droneCount = station.getDroneSet().size();
                if (droneCount < fewestDrones) {
                    stationWithFewestDrones = station;
                    fewestDrones = droneCount;
                }
            }
            return stationWithFewestDrones;
        }

    }



}
