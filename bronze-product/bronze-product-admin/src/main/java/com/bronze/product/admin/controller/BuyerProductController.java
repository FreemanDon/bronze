package com.bronze.product.admin.controller;

import com.bronze.common.util.ResultVOUtil;
import com.bronze.common.vo.ResultVO;
import com.bronze.product.dao.model.ProductCategory;
import com.bronze.product.dao.model.ProductInfo;
import com.bronze.product.dao.vo.ProductInfoVO;
import com.bronze.product.dao.vo.ProductVO;
import com.bronze.product.rpc.api.CategoryService;
import com.bronze.product.rpc.api.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Don
 * @version 1.0
 * @create 2018-03-20 21:27
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    private ProductService productService;


    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product" ,key = "#sellerId",condition = "#sellerId.length()>3",unless = "#result.getCode() != 0")//spel表达式 key的用法,condition中条件成立，才缓存.unless 如果不
    public ResultVO list(String sellerId){
        //查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //查询类目(一次性查询)
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        //java8特性 lambda
        /*List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());*/
        //类目的列表
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //首先编辑-类目(productVo)
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCatagoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            //遍历商品详情（productInfo）
            for (ProductInfo productInfo : productInfoList) {
                //比较type是否相等
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //将productInfo的对象属性的值复制到productInfoVO对象中
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
