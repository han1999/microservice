package com.hanxiao;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.Charset;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/7/18
 **/

public class TransactionProducer {
    public static void main(String[] args) throws MQClientException {
        // 创建一个producer对象(专门用来发送事务消息)
        TransactionMQProducer producer = new TransactionMQProducer("test_tx_producer");
        producer.setNamesrvAddr("localhost:9876");

        //设置监听器
        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                // 应该执行本地事务的逻辑
                System.out.println("TransactionProducer.executeLocalTransaction: " + msg.getTransactionId());
//                return LocalTransactionState.UNKNOW;
//                return LocalTransactionState.ROLLBACK_MESSAGE;
                return LocalTransactionState.COMMIT_MESSAGE;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println("TransactionProducer.checkLocalTransaction: " + msg.getTransactionId());
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        });


        //启动producer
        producer.start();

        //准备待发送消息
        Message message = new Message();
        message.setTopic("test_tx");
        message.setBody("hello. tx".getBytes(Charset.forName("utf-8")));


        //发送事务消息
        TransactionSendResult transactionSendResult = producer.sendMessageInTransaction(message, null);
        System.out.println("transactionSendResult = " + transactionSendResult);
    }
}
