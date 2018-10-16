package com.bronze.product.rpc.api;


import com.bronze.product.common.common.DecreaseStockInput;
import com.bronze.product.common.common.ProductInfoOutput;
import com.bronze.product.dao.model.ProductInfo;

import java.util.List;


/**
 * @author Don
 * @version 1.0
 * @create 2018-03-20 20:42
 **/
public interface ProductService {


    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
