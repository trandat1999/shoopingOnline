package com.tranhuudat.shoppping.repository;

import com.tranhuudat.shoppping.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleModel, Long> {
	RoleModel findByName(String name);
}
