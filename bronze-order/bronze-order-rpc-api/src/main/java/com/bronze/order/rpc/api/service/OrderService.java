package com.bronze.order.rpc.api.service;

import com.bronze.order.dao.dto.OrderDTO;

/**
 * @author Don
 * @version V1.0
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @Creation Date:2018-10-10
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
