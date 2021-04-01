package com.tranhuudat.shoppping.service.impl;

import java.util.List;

import com.tranhuudat.shoppping.model.AddressModel;
import com.tranhuudat.shoppping.repository.IAddressRepository;
import com.tranhuudat.shoppping.service.IAddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private IAddressRepository addressRepo;

    @Override
    public List<AddressModel> findAll() {
        return addressRepo.findAll();
    }

    @Override
    public Page<AddressModel> findAll(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1, pageSize);
        return addressRepo.findAll(pageable);
    }

    @Override
    public AddressModel save(AddressModel addressModel) {
        try {
            return addressRepo.save(addressModel);
        } catch (Exception e) {
            return null;
        }
    }
    
}
