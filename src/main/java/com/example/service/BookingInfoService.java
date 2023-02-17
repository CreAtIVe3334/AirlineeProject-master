package com.example.service;

import com.example.repository.BookingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingInfoService {
    @Autowired
    BookingInfoRepository bookingInfoRepository;



}
