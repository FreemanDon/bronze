package com.bronze.product.rpc.api;

import com.bronze.product.dao.model.ProductCategory;

import java.util.List;

/**
 * 描述类目接口
 *
 * @author Don
 * @create 2018-03-07 22:20
 **/
public interface CategoryService {

    List<ProductCategory> findAll();

    List<ProductCategory>findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
