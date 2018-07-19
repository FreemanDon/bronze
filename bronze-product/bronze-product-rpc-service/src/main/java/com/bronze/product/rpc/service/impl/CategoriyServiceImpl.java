package com.bronze.product.rpc.service.impl;

import com.bronze.product.dao.mapper.ProductCategoryRepository;
import com.bronze.product.dao.model.ProductCategory;
import com.bronze.product.rpc.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现描述类目接口
 *
 * @author Don
 * @create 2018-03-07 22:24
 **/
@Service
public class CategoriyServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
