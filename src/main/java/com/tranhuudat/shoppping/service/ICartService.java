package com.tranhuudat.shoppping.service;

import com.tranhuudat.shoppping.model.CartModel;


public interface ICartService {
    Boolean save(CartModel cartModel);
    Boolean update(CartModel cartModel);
    CartModel findById(long id);
}
