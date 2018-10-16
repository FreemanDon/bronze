package com.bronze.order.dao.mapper;

import com.bronze.order.dao.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.dao
 * @Description: TODO
 * @Creation Date:2018-03-28
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
