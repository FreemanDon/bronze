package com.bronze.product.dao.mapper;

import com.bronze.product.dao.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.dao
 * @Description: TODO
 * @Creation Date:2018-03-28
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrOrderId(String orderid);
}
