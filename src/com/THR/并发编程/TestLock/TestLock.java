package com.THR.�������.TestLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock()��ʹ�÷���
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
            System.out.println(threadName + "�õ�����");
            for (int i = 0; i < 10; i ++) {
                System.out.println(threadName + ": " + i);
            }
        } catch (Exception e) {
            System.out.println(threadName + "�������쳣.....");
        } finally {
            System.out.println(threadName + "�ͷ�����.....");
            lock.unlock();
        }
    }
}
