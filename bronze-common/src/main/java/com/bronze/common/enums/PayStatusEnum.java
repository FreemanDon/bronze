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
public enum PayStatusEnum implements CodeEnum{
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
