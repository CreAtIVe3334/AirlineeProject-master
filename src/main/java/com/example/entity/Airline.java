package com.example.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "airline_size",nullable = false)
    @Size(min = 5,max = 500,message = "size of Airline name must be betwen 5 and 500")
    private String name;

}
