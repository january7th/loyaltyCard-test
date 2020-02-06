package com.example.test.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOYALTY_CARD_TYPE")
public class LoyaltyCardType {
    @Id
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Spent_Threshold")
    private Long spentThreshold;

    @Column(name = "Duration")
    private Long duration;

    @Column(name = "Discount_Percent")
    private double discoutPercent;

    @Temporal(TemporalType.DATE)
    @Column(name = "Created_On")
    private Date createdOn;

    @Temporal(TemporalType.DATE)
    @Column(name = "Modified_On")
    private Date modifiedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSpentThreshold() {
        return spentThreshold;
    }

    public void setSpentThreshold(Long spentThreshold) {
        this.spentThreshold = spentThreshold;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public double getDiscoutPercent() {
        return discoutPercent;
    }

    public void setDiscoutPercent(double discoutPercent) {
        this.discoutPercent = discoutPercent;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
