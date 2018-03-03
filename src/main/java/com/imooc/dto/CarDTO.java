package com.imooc.dto;

import lombok.Data;

@Data
public class CarDTO {

//    商品id
    private String productId;
//    数量
    private Integer productQuantity;

    public CarDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
