package org.example.cashback.repository;

import org.example.cashback.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("select sum(t.cashbackAmount) from Transaction t where t.user.id =:userId")
    Long getCashback(@Param("userId") Long userId);
}
