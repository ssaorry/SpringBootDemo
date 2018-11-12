package com.springboot.jingfei.SpringBoot.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderInterface")
public class Order implements OrderInterface {

    @Autowired
    private OrderAsyncAopInterface orderAsyncAopInterface;

    @Override
    public void orderAirplan() {
        System.out.println(Thread.currentThread().getName() + ": 定飞机票");
    }

    @Override
    public void orderHotel() {
        System.out.println(Thread.currentThread().getName() + ": 定酒店");
    }

    @Override
    public void generatorOrder() {
        orderAirplan();
        orderHotel();
        orderAsyncAopInterface.sendMessage();
    }
}
