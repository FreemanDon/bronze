package com.bronze.product.rpc.service.impl;

import com.bronze.common.enums.ProductStatusEnum;
import com.bronze.common.enums.ResultEnum;
import com.bronze.product.common.common.DecreaseStockInput;
import com.bronze.product.common.common.ProductInfoOutput;
import com.bronze.product.common.exception.ProductException;
import com.bronze.product.dao.mapper.ProductInfoRepository;
import com.bronze.product.dao.model.ProductInfo;
import com.bronze.product.rpc.api.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Don
 * @version V1.0
 * @Package: com.bronze.product.rpc.service.impl
 * @Description: TODO
 * @Creation Date:2018-10-10
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> cartDTOList) {
        for (DecreaseStockInput decreaseStockInput : cartDTOList) {
            //商品是否存在
            Optional<ProductInfo> byId = productInfoRepository.findById(decreaseStockInput.getProductId());
            if (!byId.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //商品库存是否充足
            ProductInfo productInfo = byId.get();
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
