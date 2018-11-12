package com.springboot.jingfei.SpringBoot.aop;

import com.springboot.jingfei.SpringBoot.utils.springUtils.SpringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("orderAsyncAopInterface")
public class OrderAsyncAop implements OrderAsyncAopInterface{

    @Async("threadPoolTaskExecutor")
    @Override
    public void sendMessage() {
        System.out.println(Thread.currentThread().getName() + ": 发送短信");
        // 在动态代理的类方法中调用另外一个方法不能和字节用this.方法调用
        // 需要使用代理类的对象调用
        OrderAsyncAopInterface orderAsyncAopInterface = SpringUtils.getBean(OrderAsyncAopInterface.class);
        orderAsyncAopInterface.sendMail();
    }

    @Async("threadPoolTaskExecutor")
    @Override
    public void sendMail() {
        System.out.println(Thread.currentThread().getName() + ": 发送邮箱");
    }
}
