package com.bronze.product.client;

import com.bronze.product.common.common.DecreaseStockInput;
import com.bronze.product.common.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Don
 * @version V1.0
 * @Package: com.bronze.order.admin.client
 * @Description: 服务接口类
 * @Creation Date:2018-07-20
 */
@FeignClient(name = "bronze-product-admin")
public interface ProductClient {

    @GetMapping("/msg")
    String productServerMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
