package com.bronze.common.enums;

import lombok.Getter;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.enums
 * @Description: TODO
 * @Creation Date:2018-03-28
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
    FINISHED(1,"已完成"),
    CANCEL(2,"取消订单")
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
