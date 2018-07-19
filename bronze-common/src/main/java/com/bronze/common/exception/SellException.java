package com.bronze.common.exception;

import com.bronze.common.enums.ResultEnum;
import lombok.Getter;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.exception
 * @Description: TODO
 * @Creation Date:2018-03-28
 */
@Getter
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
