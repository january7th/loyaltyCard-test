package com.example.test.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOYALTY_CARD")
public class LoyaltyCard {
    @Id
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Code", nullable = false)
    private String code;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Loyalty_Card_Type_Id", nullable = false)
    private Long loyaltyCardTypeId;

    @Column(name = "Point")
    private double point;

    @Column(name = "Total_Sent")
    private Long totalSent;

    @Temporal(TemporalType.DATE)
    @Column(name = "Start_Date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "End_Date", nullable = false)
    private Date endDate;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getLoyaltyCardTypeId() {
        return loyaltyCardTypeId;
    }

    public void setLoyaltyCardTypeId(Long loyaltyCardTypeId) {
        this.loyaltyCardTypeId = loyaltyCardTypeId;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Long getTotalSent() {
        return totalSent;
    }

    public void setTotalSent(Long totalSent) {
        this.totalSent = totalSent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
