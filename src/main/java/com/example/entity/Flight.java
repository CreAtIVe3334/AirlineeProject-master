package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String destination;
    private String duration;
    private LocalDate flightDate;
    private LocalTime flightTime;
    private String flightNo;
    private String origin;
    @OneToOne(cascade = CascadeType.ALL)
    private Fare fare;
    @OneToOne(cascade = CascadeType.ALL)
    private Inventory inventory;
    @OneToOne(cascade = CascadeType.ALL)
    private FlightInfo flightInfo;

}
