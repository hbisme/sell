package com.imooc.enums;

import lombok.Getter;

@Getter
public enum  OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"已取消"),
    ;

    private Integer Code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        Code = code;
        this.message = message;
    }
}
