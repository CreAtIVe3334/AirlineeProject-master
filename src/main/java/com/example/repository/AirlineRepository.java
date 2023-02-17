package com.example.repository;

import com.example.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline,Integer> {
    Airline findByName(String airlineName);
}
