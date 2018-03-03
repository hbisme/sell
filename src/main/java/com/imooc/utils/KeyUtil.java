package com.imooc.utils;


import java.util.Random;

public class KeyUtil {
// 生成id
    public static synchronized String getUniquKey(){
        Random random = new Random();
        Integer number = random.nextInt(9000)+1000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
