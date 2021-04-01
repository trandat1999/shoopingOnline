package com.tranhuudat.shoppping.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class ItemModel extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToOne(targetEntity = CategoryModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryModel categoryModel;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Lob
    @Column(name = "picture", length = 1000)
    private byte[] picture;

    @OneToMany(mappedBy = "itemModel", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CommentModel> commentModels;

}
