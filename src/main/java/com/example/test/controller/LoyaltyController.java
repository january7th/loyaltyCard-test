package com.example.test.controller;

import com.example.test.entity.LoyaltyCard;
import com.example.test.service.LoyaltyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-v1")
public class LoyaltyController {

    @Autowired
    private LoyaltyCardService loyaltyCardService;

    @CrossOrigin
    @RequestMapping(value = "/loyaltyCard", method = RequestMethod.POST)
    public ResponseEntity<List<LoyaltyCard>> updatePoint() {
        List<LoyaltyCard> result = loyaltyCardService.updatePoint();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
