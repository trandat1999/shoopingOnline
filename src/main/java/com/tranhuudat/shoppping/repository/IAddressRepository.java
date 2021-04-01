package com.tranhuudat.shoppping.repository;

import com.tranhuudat.shoppping.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<AddressModel, Long> {
}
