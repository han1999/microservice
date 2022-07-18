package com.hanxiao;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.lang.String;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/7/18
 **/

public class TransactionConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_tx_consumer");
        consumer.setNamesrvAddr("localhost:9876");

        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                try {
                    MessageExt messageExt = msgs.get(0);
                    byte[] body = messageExt.getBody();
                    String data = new String(body, 0, body.length, "utf-8");
                    String transactionId = messageExt.getTransactionId();
                    System.out.println("transactionId = " + transactionId);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.subscribe("test_tx", "*");
        consumer.start();

    }
}
