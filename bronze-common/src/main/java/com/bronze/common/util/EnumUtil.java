package com.bronze.common.util;

import com.bronze.common.enums.CodeEnum;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.utils
 * @Description: TODO
 * @Creation Date:2018-04-09
 */
public class EnumUtil {
    //<T extends CodeEnum>对枚举的说明
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

    public static <T extends CodeEnum> T getByMessage(String message, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (message.equals(each.getMessage())) {
                return each;
            }
        }
        return null;
    }
}