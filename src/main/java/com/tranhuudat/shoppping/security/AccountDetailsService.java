package com.tranhuudat.shoppping.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tranhuudat.shoppping.model.AccountModel;
import com.tranhuudat.shoppping.repository.IAccountRepository;

@Service
public class AccountDetailsService implements UserDetailsService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountModel accountModel = accountRepository.findByUsername(username);
        AccountDetails accountDetails = new AccountDetails(accountModel.getUsername(), accountModel.getPassword(),
                accountModel.isEnabled(), true, true, true,
                AuthorityUtils.createAuthorityList(accountModel.getRole().getName()));
        accountDetails.setFullName(accountModel.getFullName());
        accountDetails.setCartModel(accountModel.getCartModel());
        return accountDetails;
    }
}
