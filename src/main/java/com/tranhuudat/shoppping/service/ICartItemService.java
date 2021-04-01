package com.tranhuudat.shoppping.service;

import java.util.List;

import com.tranhuudat.shoppping.model.CartItemModel;
import com.tranhuudat.shoppping.model.CartModel;

import org.springframework.stereotype.Service;

@Service
public interface ICartItemService {
    Boolean update(CartItemModel cartItemModel);
    List<CartItemModel> findByCart(CartModel cartModel);
    boolean delete(CartItemModel cartItemModel);
}
