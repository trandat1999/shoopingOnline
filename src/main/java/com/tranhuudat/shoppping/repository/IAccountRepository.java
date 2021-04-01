package com.tranhuudat.shoppping.repository;

import com.tranhuudat.shoppping.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<AccountModel, Long> {
    AccountModel findByUsername(String username);
    AccountModel findOneByUsernameAndPassword(String username, String password);
}
