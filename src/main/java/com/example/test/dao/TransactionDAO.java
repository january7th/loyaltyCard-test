package com.example.test.dao;

import com.example.test.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionDAO extends CrudRepository<Transaction, Long> {
    List<Transaction> findAllByLoyaltyCardIdLike(Long id);
}
