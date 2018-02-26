package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.OrderMaster;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    @Transactional
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2018022613");
        orderDetail.setOrderId("2018022613");
        orderDetail.setProductId("112");
        orderDetail.setProductPrice(new BigDecimal(3.3));
        orderDetail.setProductName("玉米粥");
        orderDetail.setProductQuantity(1);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }



    @Test
    public void findByOrderId() throws Exception {
       List<OrderDetail> orderDetailList = repository.findByOrderId("2018022601");
       Assert.assertNotEquals(0,orderDetailList.size());
    }
}