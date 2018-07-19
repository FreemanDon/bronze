package com.bronze.product.dao.dto;

import lombok.Data;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.dto
 * @Description: 购物车
 * @Creation Date:2018-03-28
 */
@Data
public class CartDTO {
    /*商品Id*/
    private String productId;
    /*商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
