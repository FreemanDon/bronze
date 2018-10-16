package com.bronze.product.common.exception;

import com.bronze.common.enums.ResultEnum;

/**
 * @author Don
 * @version V1.0
 * @Package: com.bronze.product.common.exception
 * @Description: TODO
 * @Creation Date:2018-10-11
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}