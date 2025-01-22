package org.example.cashback.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.cashback.entity.Product;

import java.util.List;
@Getter
@Setter
public class CreateTransactionResult {

    private String transactionId;
    private Long amount;
    private Long cashbackAmount;
    private List<Product> products;
    private Long userId;
    private Long customerId;

    public CreateTransactionResult(String transactionId, Long amount, Long cashbackAmount, List<Product> products, Long userId, Long customerId) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.cashbackAmount = cashbackAmount;
        this.products = products;
        this.userId = userId;
        this.customerId = customerId;
    }
}
