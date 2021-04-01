package com.tranhuudat.shoppping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class AddressModel extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name= "city")
    private String city;
    
    @Column(name="country")
    private String country;
    
    @Column(name="streets")
    private String streets;

    @ManyToOne(targetEntity = AccountModel.class)
    @JoinColumn(name = "account_id")
    private AccountModel accountModel;

}
