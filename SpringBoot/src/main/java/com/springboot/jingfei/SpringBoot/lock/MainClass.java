package com.springboot.jingfei.SpringBoot.lock;

public class MainClass {
    public static void main(String[] args){
        Lock lock = new NotSyncLock();
        Counter counter = new Counter(lock);
        try {
            counter.doAdd();
            counter.print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
