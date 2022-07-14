package com.hanxiao;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/7/14
 **/

public class DelayConsumer {
    public static void main(String[] args) throws MQClientException {
        //准备consumer对象
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_delay_consumer");

        //设置nameserver地址
        consumer.setNamesrvAddr("127.0.0.1:9876");

        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                long endTime = System.currentTimeMillis();
                MessageExt messageExt = msgs.get(0);
                String startTimeStr = messageExt.getUserProperty("startTime");
                long startTime = Long.parseLong(startTimeStr);
                long useTime = endTime - startTime;
                System.out.println("useTime = " + useTime);
                byte[] body = messageExt.getBody();
                try {
                    String data = new String(body, 0, body.length, "utf-8");
                    System.out.println("data = " + data);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.subscribe("test_delay", "*");
        consumer.start();

    }
}
