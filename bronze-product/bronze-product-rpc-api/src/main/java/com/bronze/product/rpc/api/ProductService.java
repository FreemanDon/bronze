package com.bronze.product.rpc.api;


import com.bronze.product.dao.dto.CartDTO;
import com.bronze.product.dao.model.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * @author Don
 * @version 1.0
 * @create 2018-03-20 20:42
 **/
public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);

}
