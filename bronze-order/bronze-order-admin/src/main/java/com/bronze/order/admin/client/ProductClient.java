package com.bronze.order.admin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Don
 * @version V1.0
 * @Package: com.bronze.order.admin.client
 * @Description: 服务接口类
 * @Creation Date:2018-07-20
 */
@FeignClient(name = "bronze-product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();
}
