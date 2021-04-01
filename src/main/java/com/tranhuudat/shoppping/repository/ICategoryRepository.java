package com.tranhuudat.shoppping.repository;

import com.tranhuudat.shoppping.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryModel,Long> {
}
