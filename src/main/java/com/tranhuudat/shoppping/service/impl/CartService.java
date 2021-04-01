package com.tranhuudat.shoppping.service.impl;

import com.tranhuudat.shoppping.model.CartModel;
import com.tranhuudat.shoppping.repository.ICartRepository;
import com.tranhuudat.shoppping.service.ICartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {

    @Autowired
    ICartRepository cartRepo;

    @Override
    public Boolean save(CartModel cartModel) {
        try {
            cartRepo.save(cartModel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean update(CartModel cartModel) {
        try {
            cartRepo.save(cartModel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public CartModel findById(long id) {
        return cartRepo.findById(id).get();
    }

}
