package com.tranhuudat.shoppping.repository;

import com.tranhuudat.shoppping.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<CartModel,Long> {
}
