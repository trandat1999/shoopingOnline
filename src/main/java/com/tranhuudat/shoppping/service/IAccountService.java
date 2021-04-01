package com.tranhuudat.shoppping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tranhuudat.shoppping.model.AccountModel;

@Service
public interface IAccountService{
    List<AccountModel> findAll();
    Boolean save(AccountModel accountModel);
    AccountModel findByUsername(String name);
}
