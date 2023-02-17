package com.example.entity;

import com.example.enums.Currency;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
public class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Currency currency;
    private BigDecimal fare;
}
