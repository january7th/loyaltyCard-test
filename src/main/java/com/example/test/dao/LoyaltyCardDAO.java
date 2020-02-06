package com.example.test.dao;

import com.example.test.entity.LoyaltyCard;
import org.springframework.data.repository.CrudRepository;

public interface LoyaltyCardDAO extends CrudRepository<LoyaltyCard, Long> {
}
