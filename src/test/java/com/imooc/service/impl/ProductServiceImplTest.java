package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findById() {
        ProductInfo result =productService.findById("2018022501");
        Assert.assertEquals("2018022501",result.getProductId());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> result = productService.findAll(request);
//        System.out.println(result.getTotalElements());
//        Assert.assertNotEquals(0,request.get);
        Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    @Transactional
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("2018022505");
        productInfo.setProductName("黑米粥");
        productInfo.setProductPrice(new BigDecimal(3.3));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的黑米粥");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);
        Assert.assertEquals("2018022505",result.getProductId());

    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> upResult = productService.findByProductStatus(ProductStatusEnum.UP.getCode());
        Assert.assertNotEquals(0,upResult.size());
        List<ProductInfo> downResult = productService.findByProductStatus(ProductStatusEnum.DOWN.getCode());
        Assert.assertNotEquals(0,downResult.size());
    }
}