package com.bronze.product.dao.mapper;

import com.bronze.product.dao.model.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.dao
 * @Description: TODO
 * @Creation Date:2018-04-11
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}