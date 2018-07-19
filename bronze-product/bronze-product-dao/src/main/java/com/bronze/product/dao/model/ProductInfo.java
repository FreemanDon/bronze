package com.bronze.product.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Don
 * @version 1.0
 * @create 2018-03-20 20:20
 **/
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;
    //名字
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图标
    private String productIcon;
    //状态 0正常1下架
    private Integer productStatus;
    //类目编号
    private Integer categoryType;

    private Date createTime;
    /**
     * updateTime自动更新 可以使用DynamicUpdate
     * */
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }

}
