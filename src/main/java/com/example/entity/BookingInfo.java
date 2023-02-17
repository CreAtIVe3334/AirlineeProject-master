package com.example.entity;

import com.example.enums.StatusBooking;
import lombok.*;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
public class BookingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime BookingDateTime;
    private String destination;
    private String origin;
    private BigDecimal fare;
    private LocalDate flightDate;
    private LocalTime flightTime;
    private String flightNumber;
    private StatusBooking status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "booking_info_detail",joinColumns = {@JoinColumn(name = "booking_id" ,referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "id",referencedColumnName = "id")})
    private List<Passenger> passengers;
}
