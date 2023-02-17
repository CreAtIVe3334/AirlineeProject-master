package com.example.controller;

import com.example.MyResponseEntity;
import com.example.entity.Flight;
import com.example.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("admin")
public class AdminPanelController {
    @Autowired
    private FlightService flightService;
    @PostMapping("addFlight")
    public MyResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        return new MyResponseEntity<Flight>(flightService.flightSave(flight), flight.getDuration()+" -> " +flight.getDestination() + " created");
    }
}
