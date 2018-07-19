package com.bronze.product.dao.mapper;

import com.bronze.product.dao.model.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.dao
 * @Description: TODO
 * @Creation Date:2018-03-28
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    /**按照买家的openid来查*/
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
