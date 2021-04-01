package com.tranhuudat.shoppping.service.impl;

import java.util.List;

import com.tranhuudat.shoppping.model.AccountModel;
import com.tranhuudat.shoppping.model.CartModel;
import com.tranhuudat.shoppping.repository.IAccountRepository;
import com.tranhuudat.shoppping.repository.ICartRepository;
import com.tranhuudat.shoppping.repository.IRoleRepository;
import com.tranhuudat.shoppping.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private ICartRepository cartRepo;
	@Autowired
	private IAccountRepository accountRepository;

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<AccountModel> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Boolean save(AccountModel accountModel) {
		try {
			accountModel.setPassword(passwordEncoder.encode(accountModel.getPassword()));
			accountModel.setEnabled(true);
			accountModel.setRole(roleRepository.findByName("USER"));
			accountRepository.save(accountModel);
			CartModel cart= new CartModel();
			cartRepo.save(cart);
			accountModel.setCartModel(cart);
			accountRepository.save(accountModel);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public AccountModel findByUsername(String name) {
		return accountRepository.findByUsername(name);
	}

}
