package org.example.cashback.controller;

import lombok.RequiredArgsConstructor;
import org.example.cashback.dto.TransactionDTO;
import org.example.cashback.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.ok(transactionService.create(transactionDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Long> getCashback(@PathVariable("id") Long id) {
        return ResponseEntity.ok(transactionService.getCashback(id));
    }

    @GetMapping
    public ResponseEntity<List<?>> getList() {
        return ResponseEntity.ok(transactionService.getList());
    }

}
