package com.example.test.service;

import com.example.test.entity.LoyaltyCard;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LoyaltyCardService {
    List<LoyaltyCard> updatePoint();
}
