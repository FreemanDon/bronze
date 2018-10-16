package com.bronze.common.util;

import java.util.Random;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.utils
 * @Description: TODO
 * @Creation Date:2018-03-28
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间加上随机数
     * 多线程 synchronized
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        int number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
