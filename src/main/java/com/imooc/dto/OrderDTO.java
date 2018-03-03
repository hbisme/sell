package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.utils.serializer.Date2LongSerializer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import lombok.Data;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    //    订单ID
    private String OrderId;
    //    买家姓名
    private String buyerName;
    //    买家手机号
    private String buyerPhone;
    //    买家地址
    private String buyerAddress;
    //    买家微信openid
    private String buyerOpenId;
    //    订单总金额
    private BigDecimal orderAmount;
    //    订单状态,默认为新订单
    private Integer orderStatus;
    //    支付状态，默认为未支付
    private Integer payStatus;
    //    创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    //    更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

}
