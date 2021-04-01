package com.tranhuudat.shoppping.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_item")
public class OrderItemModel extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = ItemModel.class)
    @JoinColumn(name = "item_id")
    private ItemModel itemModel;

    @Column(name = "price")
    private double price;

    @Column(name = "quanlity")
    private int quanlity;

    @ManyToOne(targetEntity = OrderModel.class)
    @JoinColumn(name = "order_id")
    private OrderModel orderModel;
}
