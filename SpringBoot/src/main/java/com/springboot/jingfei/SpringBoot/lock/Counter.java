package com.springboot.jingfei.SpringBoot.lock;

public class Counter {
        private Lock lock;

        public Counter(Lock lock){
            this.lock = lock;
        }

        public void print() throws InterruptedException {
            lock.lock();
            System.out.println("print()函数执行");
            lock.unlock();
        }
        public void doAdd() throws InterruptedException {
            lock.lock();
            System.out.println("doAdd()函数执行");
            lock.unlock();
        }
}
