package com.springboot.jingfei.SpringBoot.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 创建消费者
 */
@Component
public class MessageConsumer {
    @JmsListener(destination = "promoteAct")
    @SendTo("out.queue") // 双向队列
    public String recieveMessage(String consumer){
        System.out.println(consumer+"消息已经消费了");
        return "return message: " + consumer;
    }
}
