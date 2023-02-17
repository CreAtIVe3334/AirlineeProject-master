package com.example.controller;

import com.example.MyResponseEntity;
import com.example.entity.Flight;
import com.example.service.BookingService;
import com.example.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController("/flight/")
public class FlightController {
    @Autowired
    FlightService flightService;

    @Autowired
    BookingService bookingService;

    @GetMapping("/allFlight")
    public MyResponseEntity<List<Flight>> getAllFlight(){
        return new MyResponseEntity<List<Flight>>(flightService.getAllFlight(), "Alina bilecek biletler");
    }

    @PostMapping("buy")
    public MyResponseEntity<Flight> buyFlight(@PathVariable String flightId, @PathVariable String userId) throws Exception {
        return new MyResponseEntity<Flight>(flightService.buy(flightId,userId),"bilet alindi");
    }

}
