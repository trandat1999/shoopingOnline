package com.tranhuudat.shoppping.model;

import lombok.Data;


import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "cartitem")
public class CartItemModel extends Auditable<String> {
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = ItemModel.class)
    @JoinColumn(name = "item_id")
    private ItemModel itemModel;

    @Column(name="quanlity")
    private int quantity;

    @ManyToOne(targetEntity = CartModel.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cart_id")
    private CartModel cartModel;
}
