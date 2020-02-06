package com.example.test.service.impl;

import com.example.test.dao.ConfigDAO;
import com.example.test.dao.LoyaltyCardDAO;
import com.example.test.dao.LoyaltyCardTypeDAO;
import com.example.test.dao.TransactionDAO;
import com.example.test.entity.LoyaltyCard;
import com.example.test.entity.LoyaltyCardType;
import com.example.test.entity.Transaction;
import com.example.test.service.LoyaltyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoyaltyCardServiceImpl implements LoyaltyCardService {

    @Autowired
    private LoyaltyCardDAO loyaltyCardDAO;

    @Autowired
    private LoyaltyCardTypeDAO loyaltyCardTypeDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private ConfigDAO configDAO;

    @Override
    public List<LoyaltyCard> updatePoint() {
        List<LoyaltyCard> result = new ArrayList<>();
        List<Long> ids = new ArrayList<>();

        Iterable<LoyaltyCard> loyaltyCards = loyaltyCardDAO.findAll();

        loyaltyCards.forEach(item -> {
            List<Transaction> transactions = transactionDAO.findAllByLoyaltyCardIdLike(item.getId());
            LoyaltyCard loyaltyCard = update(item, transactions);

            result.add(loyaltyCard);
        });
        return result;
    }

    private LoyaltyCard update(LoyaltyCard loyaltyCard, List<Transaction> transactions) {
        double point = loyaltyCard.getPoint();
        long totalSent = loyaltyCard.getTotalSent();
        List<LoyaltyCardType> loyaltyCardTypes = loyaltyCardTypeDAO.findAllByOrderBySpentThresholdAsc();

        for (Transaction item: transactions) {
            point += item.getPointAdjust();
            totalSent += item.getSpentAdjust();
        }
        loyaltyCard.setPoint(point);
        loyaltyCard.setTotalSent(totalSent);
        int lent = loyaltyCardTypes.size() - 1;
        if (totalSent > loyaltyCardTypes.get(lent).getSpentThreshold()) {
            loyaltyCard.setLoyaltyCardTypeId(loyaltyCardTypes.get(lent).getId());
        } else {
            for (int i = 0; i < loyaltyCardTypes.size(); i++) {
                if (totalSent < loyaltyCardTypes.get(i).getSpentThreshold()) {
                    loyaltyCard.setLoyaltyCardTypeId(loyaltyCardTypes.get(i - 1).getId());
                    break;
                }
            }
        }

        LoyaltyCard result = loyaltyCardDAO.save(loyaltyCard);
        return result;
    }
}
