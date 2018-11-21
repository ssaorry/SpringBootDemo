package com.springboot.jingfei.SpringBoot.lock;

public interface Lock {
    void lock() throws InterruptedException;
    void unlock();
}
