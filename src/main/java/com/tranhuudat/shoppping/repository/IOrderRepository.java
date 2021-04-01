package com.tranhuudat.shoppping.repository;

import com.tranhuudat.shoppping.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderModel,Long> {
}
