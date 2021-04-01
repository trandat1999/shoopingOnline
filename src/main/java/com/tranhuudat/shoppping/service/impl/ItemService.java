package com.tranhuudat.shoppping.service.impl;

import java.util.List;

import com.tranhuudat.shoppping.model.ItemModel;
import com.tranhuudat.shoppping.repository.IItemRepository;
import com.tranhuudat.shoppping.service.IItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemService implements IItemService {
	
	@Autowired
	private IItemRepository itemRepo;

	@Override
	public List<ItemModel> findAllItem() {
		return itemRepo.findAll();
	}

	@Override
	public Boolean saveItem(ItemModel itemModel) {
		try {
			itemRepo.save(itemModel);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void deleteItemById(long id) {
		itemRepo.deleteById(id);
	}

	@Override
	public ItemModel getItemById(long id) {
		return  itemRepo.findById(id).get();
	}

	@Override
	public Page<ItemModel> findPage(int page, int pageSize) {
		Pageable pageable= PageRequest.of(page-1, pageSize);
		return this.itemRepo.findAll(pageable);
	}

	@Override
	public ItemModel findByName(String name) {
		return this.itemRepo.findByName(name);
	}

	@Override
	public ItemModel findById(Long id) {
		return itemRepo.findById(id).get();
	}

}
