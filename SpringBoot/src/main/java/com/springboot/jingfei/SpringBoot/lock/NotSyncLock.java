package com.springboot.jingfei.SpringBoot.lock;

/**
 * 可重入锁
 */
public class NotSyncLock implements Lock{
    private boolean isLocked = false;
    private Thread  lockedBy = null;
    private int lockedCount = 0;

    public synchronized void lock() throws InterruptedException{
        Thread thread = Thread.currentThread();
        while(isLocked && lockedBy != thread){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }

    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;
            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }
}