package com.example.service;

import com.example.entity.Airline;
import com.example.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    @Autowired
    AirlineRepository airlineRepository;

    public List<Airline> getAllAirline(){
        return airlineRepository.findAll();
    }

    public Airline getAirlineById(Integer id){
        return airlineRepository.findById(id).get();
    }

    public Airline save(Airline airline){
        return airlineRepository.save(airline);
    }

    public Airline getAirlineByName(String name){
        return airlineRepository.findByName(name);
    }
}
