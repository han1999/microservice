package com.hanxiao;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.Charset;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/7/14
 **/

public class DelayProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("test_delay_producer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        //启动producer
        producer.start();

        //准备待发送的消息
        String data = "hello, delay message";
        String topic = "test_delay";
        Message message = new Message(topic, data.getBytes(Charset.forName("utf-8")));
        message.setDelayTimeLevel(3);


        //发送消息
        long startTime = System.currentTimeMillis();
        message.putUserProperty("startTime", startTime + "");
        SendResult sendResult = producer.send(message);
        System.out.println("sendResult = " + sendResult);
    }
}
