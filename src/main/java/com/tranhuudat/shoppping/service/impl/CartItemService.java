package com.tranhuudat.shoppping.service.impl;

import java.util.List;

import com.tranhuudat.shoppping.model.CartItemModel;
import com.tranhuudat.shoppping.model.CartModel;
import com.tranhuudat.shoppping.repository.ICartItemRepository;
import com.tranhuudat.shoppping.service.ICartItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService implements ICartItemService {

    @Autowired
    private ICartItemRepository cartItemRepo;

    @Override
    public Boolean update(CartItemModel cartItemModel) {
        try {
            cartItemRepo.save(cartItemModel);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<CartItemModel> findByCart(CartModel cartModel) {
        return cartItemRepo.findAllByCartModel(cartModel);
    }

    @Override
    public boolean delete(CartItemModel cartItemModel) {
        try {
            cartItemRepo.delete(cartItemModel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
