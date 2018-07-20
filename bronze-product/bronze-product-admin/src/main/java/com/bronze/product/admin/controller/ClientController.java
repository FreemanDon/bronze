package com.bronze.product.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Don
 * @version V1.0
 * @Package: com.bronze.product.admin.controller
 * @Description: 测试接口
 * @Creation Date:2018-07-20
 */
@RestController
public class ClientController {
    @GetMapping("/msg")
    public String msg() {
        return "HELLO WORLD";
    }
}
