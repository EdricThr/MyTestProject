package com.THR.并发编程;

/**
 * THread 的子类
 *
 * @author Thr
 */
public class MyThread extends Thread {
    private static int threadNum = 0;
    @Override
    public void run() {
        System.out.println("-------->run()  第" + threadNum + "个 线程, 线程号：" + Thread.currentThread().getId());
    }
    public MyThread() {
        threadNum ++;
    }
}
