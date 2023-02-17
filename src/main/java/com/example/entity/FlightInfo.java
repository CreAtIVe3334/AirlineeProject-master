package com.example.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
public class FlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String flightNumber;
    private Integer countSeets;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Airline_flight_info",joinColumns = {@JoinColumn(name = "id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "Ai_id", referencedColumnName = "id")})
    private Airline airline;
}
