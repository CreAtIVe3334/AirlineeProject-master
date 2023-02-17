package com.example.service;

import com.example.entity.Passenger;
import com.example.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    public Passenger save(Passenger passenger){
        return passengerRepository.save(passenger);
    }

    public List<Passenger> getAll(){
        return passengerRepository.findAll();
    }

    public Passenger findById(Integer id){
        return passengerRepository.findById(id).get();
    }

    public List<Passenger> saveAll(List<Passenger> passengers){
        return passengerRepository.saveAll(passengers);
    }


}

