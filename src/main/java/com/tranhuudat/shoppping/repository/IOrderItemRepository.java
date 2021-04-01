package com.tranhuudat.shoppping.repository;

import com.tranhuudat.shoppping.model.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderItemRepository extends JpaRepository<OrderItemModel,Long> {
}
