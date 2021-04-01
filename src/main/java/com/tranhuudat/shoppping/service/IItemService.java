package com.tranhuudat.shoppping.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.tranhuudat.shoppping.model.ItemModel;

@Service
public interface IItemService {
	List<ItemModel> findAllItem();
	Boolean saveItem(ItemModel itemModel);
	void deleteItemById(long id);
	ItemModel getItemById(long id);
	Page<ItemModel> findPage(int page,int pageSize);
	ItemModel findByName(String name);
	ItemModel findById(Long id);

}
