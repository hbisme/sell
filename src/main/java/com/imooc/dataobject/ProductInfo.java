package com.imooc.dataobject;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;
//    商品名称
    private String productName;
//    商品单价
    private BigDecimal productPrice;
//    商品库存
    private Integer productStock;
//    商品描述
    private String productDescription;
//    商品小图
    private String productIcon;
//    商品状态，0：正常，1下架
    private Integer productStatus;
//    商品类目编号
    private Integer categoryType;

}
