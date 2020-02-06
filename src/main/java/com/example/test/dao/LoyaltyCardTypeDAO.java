package com.example.test.dao;

import com.example.test.entity.LoyaltyCardType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoyaltyCardTypeDAO extends CrudRepository<LoyaltyCardType, Long> {
    List<LoyaltyCardType> findAllByOrderBySpentThresholdAsc();
}
