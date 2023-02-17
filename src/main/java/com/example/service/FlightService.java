package com.example.service;

import com.example.entity.BookingInfo;
import com.example.entity.Flight;
import com.example.entity.Passenger;
import com.example.entity.User;
import com.example.enums.StatusBooking;
import com.example.exceptions.BusinessException;
import com.example.help.Helper;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingInfoRepository bookingInfoRepository;
    @Autowired
    private PassengerRepository passengerRepository;


    public List<Flight> getAllFlight(){
        List<Flight> list = flightRepository.findAll().stream()
                .filter(f -> LocalDateTime.of(f.getFlightDate(),f.getFlightTime().plusHours(1)).compareTo(LocalDateTime.now())>0)
                .filter(f-> f.getFlightInfo().getCountSeets().compareTo(0)>0)
                .collect(Collectors.toList());
        return list;
    }

    public Flight flightSave(Flight flight){
        return flightRepository.save(flight);
    }


    public Flight buy(String flightId, String userId) throws Exception {

        Integer flightIdInt = Integer.parseInt(flightId);
        Integer userIdInt = Integer.parseInt(userId);
        Flight flight = flightRepository.findById(flightIdInt).orElseThrow(() -> new Exception("Flight info not fount for if:"+flightId));
        User user = userRepository.findById(userIdInt).orElseThrow(() -> new Exception("User info not fount for if:"+flightId));
        Integer inventory = flight.getInventory().getCount();
        Integer countSeats = flight.getFlightInfo().getCountSeets();
        Passenger passenger = Helper.userToPassenger(user,countSeats);

        boolean controlMoney= user.getMoney().compareTo(flight.getFare().getFare())>=0;
        boolean controlInventory = passenger.getInventory().compareTo(flight.getInventory().getCount()) <=0;
        if(controlMoney) throw  new BusinessException("Bileti almaq ucun balansinizda kifayet qeder mebleg yoxdur");
        if(controlInventory) throw new BusinessException("Inventorda qalan yer sayi " + inventory);

        BookingInfo bookingInfo = BookingInfo.builder()
                .BookingDateTime(LocalDateTime.now())
                .flightTime(flight.getFlightTime())
                .flightDate(flight.getFlightDate())
                .flightNumber(flight.getFlightNo())
                .destination(flight.getDestination())
                .origin(flight.getOrigin())
                .fare(flight.getFare().getFare())
                .passengers(List.of())
                .status(StatusBooking.RECEIVED).build();


        flight.getFlightInfo().setCountSeets(--countSeats);
        flight.getInventory().setCount(inventory - passenger.getInventory());
        user.setMoney(user.getMoney().subtract(flight.getFare().getFare()).setScale(2, RoundingMode.HALF_UP));

        bookingInfoRepository.save(bookingInfo);
        passengerRepository.save(passenger);
        flightRepository.save(flight);
        userRepository.save(user);

        return flight;

    }
    }

