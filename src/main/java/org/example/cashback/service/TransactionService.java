package org.example.cashback.service;

import lombok.RequiredArgsConstructor;
import org.example.cashback.dto.CreateTransactionResult;
import org.example.cashback.dto.TransactionDTO;
import org.example.cashback.entity.Product;
import org.example.cashback.entity.Transaction;
import org.example.cashback.repository.ProductRepository;
import org.example.cashback.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

    public CreateTransactionResult create(TransactionDTO transactionDTO) {
        List<Product> products = productRepository.findAllById(transactionDTO.getProductId());

        Long amount = 0L;
        Long cashbackAmount = 0L;


        for (Product product : products) {
            amount += product.getPrice();
            cashbackAmount = amount / 100;
        }
        Transaction transaction = new Transaction();
        transaction.setUserId(transactionDTO.getUserId());
        transaction.setCustomerId(transactionDTO.getCustomerId());
        transaction.setAmount(amount);
        transaction.setCashbackAmount(cashbackAmount);
        transaction.setProducts(products);

        transactionRepository.save(transaction);

        return new CreateTransactionResult(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getCashbackAmount(),
                transaction.getProducts(),
                transaction.getUserId(),
                transaction.getCustomerId());
    }

    public Long getCashback(Long userId) {
        return transactionRepository.getCashback(userId);
    }

    public List<?> getList() {
        return transactionRepository.findAll();
    }
}
