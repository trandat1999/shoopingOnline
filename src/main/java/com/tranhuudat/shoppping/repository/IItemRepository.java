package com.tranhuudat.shoppping.repository;

import com.tranhuudat.shoppping.model.ItemModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<ItemModel, Long> {
	ItemModel findByName(String name);
}
