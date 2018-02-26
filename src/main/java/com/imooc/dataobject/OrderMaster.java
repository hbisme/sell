package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
public class OrderMaster {
//    订单ID
    @Id
    private String OrderId;
//    买家姓名
    private String buyer_name;
//    买家手机号
    private String buyerPhone;
//    买家地址
    private String buyerAddress;
//    买家微信openid
    private String buyerOpenId;
//    订单总金额
    private BigDecimal orderAmount;
//    订单状态,默认为新订单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
//    支付状态，默认为未支付
    private Integer payStatus = PayStatusEnum.NEW.getCode();
//    创建时间
    private Date createTime;
//    更新时间
    private Date updateTime;
}
