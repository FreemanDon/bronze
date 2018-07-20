package com.bronze.product.dao.dto;

import com.bronze.common.enums.OrderStatusEnum;
import com.bronze.common.enums.PayStatusEnum;
import com.bronze.common.util.EnumUtil;
import com.bronze.common.util.serializer.Date2LongSerializer;
import com.bronze.product.dao.model.OrderDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.dto
 * @Description: TODO
 * @Creation Date:2018-03-28
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /*订单id*/
    @Id
    private String orderId;

    /*买家名字*/
    private String buyerName;

    /*买家电话*/
    private String buyerPhone;

    /*买家地址*/
    private String buyerAddress;

    /*买家微信openid*/
    private String buyerOpenid;

    /*订单总金额*/
    private BigDecimal orderAmount;

    /*订单状态，默认0为新下单*/
    private Integer orderStatus;

    /*支付状态 默认0未支付*/
    private Integer payStatus;

    /*创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /*更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    //赋予初始值后，为null返回空的字段
    List<OrderDetail> orderDetailList = new ArrayList<>();

    //通过code获得枚举，下处方法都可以
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
