package com.bronze.product.dao.mapper;

import com.bronze.product.common.common.ProductInfoOutput;
import com.bronze.product.dao.model.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Don
 * @version 1.0
 * @create 2018-03-20 20:33
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfoOutput> findByProductIdIn(List<String> productIdList);
}
