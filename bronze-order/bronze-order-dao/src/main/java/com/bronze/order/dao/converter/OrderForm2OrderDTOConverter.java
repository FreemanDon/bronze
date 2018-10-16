package com.bronze.order.dao.converter;

import com.alibaba.fastjson.JSONObject;
import com.bronze.common.enums.ResultEnum;
import com.bronze.order.dao.dto.OrderDTO;
import com.bronze.order.dao.form.OrderForm;
import com.bronze.order.dao.model.OrderDetail;
import com.bronze.order.common.exception.OrderException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Don
 * @version V1.0
 * @Package: com.bronze.order.admin.dao.converter
 * @Description: TODO
 * @Creation Date:2018-10-10
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = JSONObject.parseArray(orderForm.getItems(), OrderDetail.class);
        } catch (Exception e) {
            log.error("【json转换】错误, string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
