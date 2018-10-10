package com.THR.并发编程.TestLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock()的使用方法
 *
 * @author Thr
 */
public class TestLock {

    private static TestLock testLock = new TestLock();
    Lock lock = new ReentrantLock();
    public static void main(String args[]){

        new Thread() {
            @Override
            public void run() {
                testLock.insert();
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                testLock.insert();
            }
        }.start();

    }

    public void insert() {
        lock.lock();
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println(threadName + "得到了锁");
            for (int i = 0; i < 10; i ++) {
                System.out.println(threadName + ": " + i);
            }
        } catch (Exception e) {
            System.out.println(threadName + "发生了异常.....");
        } finally {
            System.out.println(threadName + "释放了锁.....");
            lock.unlock();
        }
    }
}
