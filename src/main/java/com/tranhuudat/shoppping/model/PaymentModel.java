package com.tranhuudat.shoppping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class PaymentModel extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "totals")
    private double totals;

    @Column(name = "details")
    private String details;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private PaymentType paymentType;

    @ManyToOne(targetEntity = AccountModel.class)
    @JoinColumn(name = "account_id")
    private AccountModel accountModel;
}
