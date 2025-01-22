package org.example.cashback.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.cashback.enums.MarketType;

@Getter
@Setter
public class CustomerDTO {

    private Long id;
    private String name;
    private MarketType marketType;
}
