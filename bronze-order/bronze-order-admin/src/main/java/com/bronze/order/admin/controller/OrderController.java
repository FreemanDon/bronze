package com.bronze.order.admin.controller;

import com.bronze.order.admin.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Don
 * @version V1.0
 * @Package: com.bronze.order.admin.controller
 * @Description: TODO
 * @Creation Date:2018-07-20
 */
@RestController
@Slf4j
public class OrderController {

    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }

}
