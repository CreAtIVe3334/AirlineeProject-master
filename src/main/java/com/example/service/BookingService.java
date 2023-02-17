package com.example.service;

import com.example.entity.Flight;
import com.example.entity.Passenger;
import com.example.entity.User;
import com.example.help.Helper;
import com.example.repository.FlightRepository;
import com.example.repository.PassengerRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.RoundingMode;

@Service
public class BookingService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Transactional
    public boolean buyFlight(Integer userId,Integer flightId){
        boolean boughted = false;
        User userDB=userRepository.findById(userId).get();
        Flight flightDB = flightRepository.findById(flightId).get();
        if(userDB.getMoney().compareTo(flightDB.getFare().getFare())>0){
        userDB.setMoney(userDB.getMoney().subtract(flightDB.getFare().getFare()).setScale(2, RoundingMode.HALF_UP));
        flightDB.getFlightInfo().setCountSeets(flightDB.getFlightInfo().getCountSeets()-1);
        passengerRepository.save(Helper.userToPassenger(userDB, flightDB.getFlightInfo().getCountSeets()));
        userRepository.save(userDB);
        flightRepository.save(flightDB);
        boughted = true;}
        return boughted;
    }
}
