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
 * @date: 2022/7/13
 **/

public class BasicProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("test_basic_message_producer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        Message message = new Message();
        String topic = "test_basic";
        String data = "hello! rocketmq";
        message.setTopic(topic);
        message.setBody(data.getBytes(Charset.forName("utf-8")));
        SendResult sendResult = producer.send(message);
        System.out.println("sendResult = " + sendResult);
    }
}
