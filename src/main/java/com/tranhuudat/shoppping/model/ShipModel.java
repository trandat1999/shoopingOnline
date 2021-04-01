package com.tranhuudat.shoppping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ships")
public class ShipModel extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ship_status")
    private ShipStatus shipStatus;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AddressModel.class)
    @JoinColumn(name = "address_id")
    private AddressModel addressModel;

}
