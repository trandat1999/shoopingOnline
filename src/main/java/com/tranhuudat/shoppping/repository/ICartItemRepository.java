package com.tranhuudat.shoppping.repository;

import java.util.List;

import com.tranhuudat.shoppping.model.CartItemModel;
import com.tranhuudat.shoppping.model.CartModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItemModel,Long> {
    List<CartItemModel> findAllByCartModel(CartModel cartModel);
}
