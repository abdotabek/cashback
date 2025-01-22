package org.example.cashback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @Column(name = "customer_id")
    private Long customerId;

    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", updatable = false, insertable = false)
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Product> products;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "cashback_amount")
    private Long cashbackAmount;

}
