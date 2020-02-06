package com.example.test.init;

import com.example.test.dao.ConfigDAO;
import com.example.test.dao.LoyaltyCardDAO;
import com.example.test.dao.LoyaltyCardTypeDAO;
import com.example.test.dao.TransactionDAO;
import com.example.test.entity.Config;
import com.example.test.entity.LoyaltyCard;
import com.example.test.entity.LoyaltyCardType;
import com.example.test.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataInit implements ApplicationRunner {

    private ConfigDAO configDAO;

    private LoyaltyCardDAO loyaltyCardDAO;

    private LoyaltyCardTypeDAO loyaltyCardTypeDAO;

    private TransactionDAO transactionDAO;

    private static final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    @Autowired
    public DataInit(ConfigDAO configDAO, LoyaltyCardDAO loyaltyCardDAO, LoyaltyCardTypeDAO loyaltyCardTypeDAO, TransactionDAO transactionDAO) {
        this.configDAO = configDAO;
        this.loyaltyCardDAO = loyaltyCardDAO;
        this.loyaltyCardTypeDAO = loyaltyCardTypeDAO;
        this.transactionDAO = transactionDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count1 = configDAO.count();
        long count2 = loyaltyCardDAO.count();
        long count3 = loyaltyCardTypeDAO.count();
        long count4 = transactionDAO.count();

        if (count1 == 0) {
            Config config = new Config();

            config.setName("POINT");
            config.setValue(100l);

            configDAO.save(config);
        }

        if (count2 == 0) {
            LoyaltyCard loyaltyCard = new LoyaltyCard();

            loyaltyCard.setId(1l);
            loyaltyCard.setCode("LT0001");
            loyaltyCard.setPhone("987654321");
            loyaltyCard.setPoint(23.45);
            loyaltyCard.setLoyaltyCardTypeId(1l);
            loyaltyCard.setTotalSent(2345000l);
            Date d1 = df.parse("12/18/2019");
            loyaltyCard.setStartDate(d1);
            Date d2 = df.parse("12/18/2020");
            loyaltyCard.setEndDate(d2);
            loyaltyCard.setCreatedOn(d1);
            loyaltyCard.setModifiedOn(d1);

            loyaltyCardDAO.save(loyaltyCard);
        }

        if (count3 == 0) {
            LoyaltyCardType loyaltyCardType1 = new LoyaltyCardType();

            loyaltyCardType1.setId(1l);
            loyaltyCardType1.setName("Thẻ chuẩn");
            loyaltyCardType1.setSpentThreshold(0l);
            loyaltyCardType1.setDuration(365l);
            loyaltyCardType1.setDiscoutPercent(1);
            Date d1 = df.parse("12/18/2019");
            loyaltyCardType1.setCreatedOn(d1);
            loyaltyCardType1.setModifiedOn(d1);

            loyaltyCardTypeDAO.save(loyaltyCardType1);

            LoyaltyCardType loyaltyCardType2 = new LoyaltyCardType();

            loyaltyCardType2.setId(2l);
            loyaltyCardType2.setName("Thẻ bạc");
            loyaltyCardType2.setSpentThreshold(5000000l);
            loyaltyCardType2.setDuration(365l);
            loyaltyCardType2.setDiscoutPercent(2);
            loyaltyCardType2.setCreatedOn(d1);
            loyaltyCardType2.setModifiedOn(d1);

            loyaltyCardTypeDAO.save(loyaltyCardType2);
        }

        if (count4 == 0) {
            Transaction transaction = new Transaction();

            transaction.setLoyaltyCardId(1l);
            transaction.setPointAdjust(30.4);
            transaction.setSpentAdjust(3040000l);
            Date d1 = df.parse("12/18/2019");
            transaction.setCreatedOn(d1);

            transactionDAO.save(transaction);
        }
    }
}
