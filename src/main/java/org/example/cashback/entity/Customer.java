package org.example.cashback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cashback.enums.MarketType;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "market_type")
    @Enumerated(EnumType.STRING)
    private MarketType marketType;

}
