package com.imooc.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    NEW(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer Code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        Code = code;
        this.message = message;
    }
}
