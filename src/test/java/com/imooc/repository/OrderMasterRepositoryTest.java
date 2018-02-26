package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private String openId = "abc";
    @Transactional
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2018022603");
        orderMaster.setBuyer_name("师各");
        orderMaster.setBuyerPhone("123456770");
        orderMaster.setBuyerAddress("瓜山");
        orderMaster.setBuyerOpenId(openId);
        orderMaster.setOrderAmount(new BigDecimal(3.2));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenId() throws Exception{
        PageRequest pageRequest = new PageRequest(0,1);
        Page<OrderMaster> result = repository.findByBuyerOpenId(openId,pageRequest);
        Assert.assertNotEquals(0,result.getContent().size());
    }




}