package com.tranhuudat.shoppping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "comment")
public class CommentModel extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String details;

	@ManyToOne(targetEntity = ItemModel.class)
	private ItemModel itemModel;

	@ManyToOne(targetEntity = AccountModel.class)
	private AccountModel accountModel;

}
