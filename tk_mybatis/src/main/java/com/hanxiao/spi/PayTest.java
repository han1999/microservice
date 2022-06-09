package com.hanxiao.spi;

import java.util.ServiceLoader;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/9
 **/

public class PayTest {
    public static void main(String[] args) {
        ServiceLoader<Pay> payServiceLoader = ServiceLoader.load(Pay.class);
        payServiceLoader.forEach(pay -> pay.payMoney(100.0));
        for (Pay pay : payServiceLoader) {
            pay.payMoney(200.0);
        }
    }
}
