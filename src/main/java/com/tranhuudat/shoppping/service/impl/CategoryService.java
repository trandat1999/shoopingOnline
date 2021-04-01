package com.tranhuudat.shoppping.service.impl;

import java.util.List;

import com.tranhuudat.shoppping.model.CategoryModel;
import com.tranhuudat.shoppping.repository.ICategoryRepository;
import com.tranhuudat.shoppping.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepo;

    @Override
    public List<CategoryModel> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public CategoryModel add(CategoryModel categoryModel) {
        try {
            return categoryRepo.save(categoryModel);
        } catch (Exception e) {
            return null;
        }
        
    }

    @Override
    public CategoryModel findById(long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public Page<CategoryModel> findAll(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1, pageSize);
        return categoryRepo.findAll(pageable);
    }
    
}
