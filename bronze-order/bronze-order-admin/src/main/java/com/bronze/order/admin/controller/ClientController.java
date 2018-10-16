package com.bronze.order.admin.controller;

import com.bronze.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Don
 * @version V1.0
 * @Package: com.bronze.order.admin.controller
 * @Description: TODO
 * @Creation Date:2018-07-20
 */
@RestController
@Slf4j
public class ClientController {

    @Resource
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = productClient.productServerMsg();
        log.info("response={}", response);
        return response;
    }
}
