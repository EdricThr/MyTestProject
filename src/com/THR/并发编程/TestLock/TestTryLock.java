package com.THR.�������.TestLock;

import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock()��ʹ�÷���
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
     * ����ͨ��lock.tryLock()�ж��̵߳õ�����״̬���Դ�ִ�������Ĳ���
     */
    public void tryLock_IfNotDo() {
        String threadName = Thread.currentThread().getName();
        if (lock.tryLock()) {
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
        } else {
            System.out.println(threadName + "δ�õ���.....");
        }
    }

    /**
     * ��ͬ��lock()�����������ǵõ�����ֻ�ǽ����ж��Ƿ��õ�������
     * δ�õ������ǻ������ߣ����³����쳣Exception in thread "Thread-1" java.lang.IllegalMonitorStateException
     */
    public void tryLock() {
        String threadName = Thread.currentThread().getName();
        lock.tryLock();
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
