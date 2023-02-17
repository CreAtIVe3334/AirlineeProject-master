package com.example.help;

import com.example.entity.Checkin;
import com.example.entity.Passenger;
import com.example.entity.User;

import java.util.Random;

public class Helper {

    private Helper(){
    }
    public static Passenger userToPassenger(User user, Integer countSeats){
        Random random = new Random();


       return   Passenger.builder().name(user.getName())
                        .surname(user.getSurname())
                        .gender(user.getGender())
                        .phoneMunber(user.getPhoneNumber())
                        .bookingId(String.valueOf(1))
                        .inventory(15)
                        .checkin(Checkin.builder().seetNumber(seatRandom(countSeats)).build()).build();
    }

    public static Integer seatRandom(Integer countSeats){
        Random random = new Random();
        return random.nextInt(1,countSeats );
    }
}
