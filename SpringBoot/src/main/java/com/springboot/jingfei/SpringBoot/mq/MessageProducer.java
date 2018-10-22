package com.springboot.jingfei.SpringBoot.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 创建生产者
 */

@Component
@EnableScheduling
public class MessageProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    /**
     * spring boot的定时任务
     * 2s执行一次
     */
    @Scheduled(fixedDelay = 2000)
    public void send(){
        jmsMessagingTemplate.convertAndSend(this.queue, "hello,queue");
    }

    // 接收消费者返回回来的消息
    @JmsListener(destination = "out.queue")
    public void recieveOutMessage(String message){
        System.out.println(message);
    }
}
