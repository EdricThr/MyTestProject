package com.THR.�������;

/**
 * THread ������
 *
 * @author Thr
 */
public class MyThread extends Thread {
    private static int threadNum = 0;
    @Override
    public void run() {
        System.out.println("-------->run()  ��" + threadNum + "�� �߳�, �̺߳ţ�" + Thread.currentThread().getId());
    }
    public MyThread() {
        threadNum ++;
    }
}
