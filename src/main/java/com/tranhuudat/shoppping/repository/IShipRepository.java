package com.tranhuudat.shoppping.repository;

import com.tranhuudat.shoppping.model.ShipModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShipRepository extends JpaRepository<ShipModel,Long> {
}
