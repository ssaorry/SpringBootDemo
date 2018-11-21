package com.springboot.jingfei.SpringBoot.lock;

/**
 * 不可重入锁
 */
public class SyncLock{
    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
