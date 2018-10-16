package com.bronze.order.common.exception;

import com.bronze.common.enums.ResultEnum;

/**
 * @author Don
 * @version V1.0
 * @Package: com.bronze.order.common.exception
 * @Description: TODO
 * @Creation Date:2018-10-10
 */
public class OrderException extends RuntimeException{
    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
