package com.tranhuudat.shoppping.service;

import java.util.List;

import com.tranhuudat.shoppping.model.AddressModel;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface IAddressService {
    List<AddressModel> findAll();
    Page<AddressModel> findAll(int page, int pageSize);
    AddressModel save(AddressModel addressModel);
}
