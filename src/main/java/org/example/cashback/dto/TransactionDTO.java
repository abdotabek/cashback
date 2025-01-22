package org.example.cashback.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionDTO {

    private Long userId;
    private Long customerId;
    private List<Long> productId;
}
