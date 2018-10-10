package com.THR.�������;

/**
 * �����̵߳ļ��з�ʽ
 *
 * @author Thr
 */
public class WaysOfCreateThread {

    /**
     * �����̵߳ķ�ʽ�����֣�
     *  1. �̳�Thread. ������̳�Thread�࣬��дrun()����ʵ�������߼���
     *  2. ʵ��Runnable. ʹ�������ڲ���򴴽�����ʵ��Runnable�ӿ�,���Threadʵ��
     * @param args
     */
    public static void main(String args[]){
        MyThread myThread = new MyThread();
        myThread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ʹ��������runnable�ķ�ʽ�����̣߳� ���С������̺߳ţ�" + Thread.currentThread().getId());
            }
        }).start();
        Thread runThread = new Thread(new myRunnable());
        runThread.start();
    }
    static class myRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("ʹ���ڲ���runnable�ķ�ʽ�����̣߳� ���С������̺߳ţ�" + Thread.currentThread().getId());
        }
    }

}
