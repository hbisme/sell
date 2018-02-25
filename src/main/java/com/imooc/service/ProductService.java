package com.imooc.service;

import com.imooc.dataobject.ProductInfo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
//商品Service层

public interface ProductService {
//    根据id查询商品信息
    ProductInfo findById(String id);
//    查询所有商品信息
    Page<ProductInfo> findAll(Pageable pageable);
//    查询所有在售商品信息
    List<ProductInfo> findUpAll();
//    新增商品信息
    ProductInfo save(ProductInfo productInfo);

//    根据状态查询商品
    List<ProductInfo> findByProductStatus(Integer status);

//    加库存

//    减库存
}
