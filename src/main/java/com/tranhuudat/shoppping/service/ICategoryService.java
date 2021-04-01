package com.tranhuudat.shoppping.service;

import java.util.List;

import com.tranhuudat.shoppping.model.CategoryModel;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryService {
    List<CategoryModel> findAll();
    CategoryModel add(CategoryModel categoryModel);
    CategoryModel findById(long id);
    Page<CategoryModel> findAll(int page, int pageSize);
}
