package com.example.test.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Loyalty_Card_Id", nullable = false)
    private Long loyaltyCardId;

    @Column(name = "Point_Adjust", nullable = false)
    private double pointAdjust;

    @Column(name = "Spent_Adjust", nullable = false)
    private Long spentAdjust;

    @Temporal(TemporalType.DATE)
    @Column(name = "Created_On", nullable = false)
    private Date createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoyaltyCardId() {
        return loyaltyCardId;
    }

    public void setLoyaltyCardId(Long loyaltyCardId) {
        this.loyaltyCardId = loyaltyCardId;
    }

    public double getPointAdjust() {
        return pointAdjust;
    }

    public void setPointAdjust(double pointAdjust) {
        this.pointAdjust = pointAdjust;
    }

    public Long getSpentAdjust() {
        return spentAdjust;
    }

    public void setSpentAdjust(Long spentAdjust) {
        this.spentAdjust = spentAdjust;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
