package com.THR.并发编程.TestLock;

import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock()的使用方法
 *
 * @author Thr
 */
public class TestTryLock {

    private static TestTryLock testLock = new TestTryLock();
    Lock lock = new ReentrantLock();
    public static void main(String args[]){

        new Thread() {
            @Override
            public void run() {
                //testLock.tryLock_IfNotDo();
                testLock.tryLock();
            }
        }.start();

        
        new Thread() {
            @Override
            public void run() {
                //testLock.tryLock_IfNotDo();
                testLock.tryLock();
            }
        }.start();

    }

    /**
     * 可以通过lock.tryLock()判断线程得到锁的状态，以此执行其他的操作
     */
    public void tryLock_IfNotDo() {
        String threadName = Thread.currentThread().getName();
        if (lock.tryLock()) {
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
        } else {
            System.out.println(threadName + "未得到锁.....");
        }
    }

    /**
     * 不同于lock()方法，并不是得到锁，只是进行判断是否拿到了锁，
     * 未得到锁还是会向下走，导致出现异常Exception in thread "Thread-1" java.lang.IllegalMonitorStateException
     */
    public void tryLock() {
        String threadName = Thread.currentThread().getName();
        lock.tryLock();
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
