package com.bronze.product.common.common;

import lombok.Data;

/**
 * @author Don
 * @version V1.0
 * @Package: com.bronze.product.common
 * @Description: 减库存入参
 * @Creation Date:2018-10-10
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
