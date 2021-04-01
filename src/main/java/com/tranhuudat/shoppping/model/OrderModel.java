package com.tranhuudat.shoppping.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class OrderModel extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "totals")
    private double totals;

    @OneToOne(targetEntity = ShipModel.class)
    @JoinColumn(name = "ship_id")
    private ShipModel shipModel;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccountModel.class)
    @JoinColumn(name = "account_id")
    private AccountModel accountModel;

    @OneToOne(targetEntity = PaymentModel.class, cascade = CascadeType.MERGE) 
    @JoinColumn(name = "pay_id")
    private PaymentModel paymentModel;

}
