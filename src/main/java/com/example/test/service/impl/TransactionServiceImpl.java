package com.example.test.service.impl;

import com.example.test.dao.TransactionDAO;
import com.example.test.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDAO transactionDAO;


}
