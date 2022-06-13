package com.hanxiao.spi;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/9
 **/

public class WeChatPay implements Pay {
    @Override
    public void payMoney(Double amount) {
        System.out.println("微信支付了"+amount);
    }
}
