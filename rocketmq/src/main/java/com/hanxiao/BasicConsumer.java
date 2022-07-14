package com.hanxiao;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/7/13
 **/

public class BasicConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_basic_message_consumer");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        //给consumer设置消息监听器
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                //可以通过方法参数获取到rocketmq中的消息，所以消息的消费逻辑代码，主要就写在监听器当中
                // 消费逻辑
                // 从消息中将数据取出来
                MessageExt messageExt = msgs.get(0);
                // 从消息体中取出数据
                try {
                    byte[] body = messageExt.getBody();
                    String msgId = messageExt.getMsgId();
                    System.out.println("msgId = " + msgId);
                    String data = new String(body, 0, body.length, Charset.forName("utf-8"));
                    System.out.println("data = " + data);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });
        //订阅主题
        consumer.subscribe("test_basic", "*");
        //启动消费者
        consumer.start();
    }
}
