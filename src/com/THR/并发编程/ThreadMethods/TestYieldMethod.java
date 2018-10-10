package com.THR.�������.ThreadMethods;

/**
 * @author Thr
 */
public class TestYieldMethod {

    private Object object = new Object();
    private int i = 10;


    public static void main(String args[]){
        doTestYieldMethod();
    }



    /**
     * ������������������н�����£�
     ��ǰ�߳�ID:10; i:10
     �߳̿�ʼ����yield()����
     ��ǰ�߳�ID:9; i:10
     �߳̿�ʼ����yield()����
     ��ǰ�߳�yield������ID:10; i:11
     ��ǰ�߳�yield������ID:9; i:12

     * ����������������н�����£�
     ��ǰ�߳�ID:10; i:10
     �߳̿�ʼ����yield()����
     ��ǰ�߳�yield������ID:10; i:11
     ��ǰ�߳�ID:9; i:12
     �߳̿�ʼ����yield()����
     ��ǰ�߳�yield������ID:9; i:13

     �ɼ���
     1. �̵߳�yield()��������Thread�����ǲ���Ҫ�����쳣
     2. yield()����ͬ�������ͷŶ�����
     3. ��֪��yield()���ܿ��ƾ���Ľ���CPU��ʱ��; ���⣬yield����ֻ����ӵ����ͬ���ȼ����߳��л�ȡCPUִ��ʱ��Ļ��ᡣ
     */
    public static void doTestYieldMethod() {
        TestYieldMethod testYieldMethod = new TestYieldMethod();
        testYieldMethod.new MyYieldBlockTestThread().start();
        testYieldMethod.new MyYieldBlockTestThread().start();
    }

    class MyYieldBlockTestThread extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println("��ǰ�߳�ID:" + Thread.currentThread().getId() + "; i:" + i++);
                System.out.println("�߳̿�ʼ����yield()����");
                Thread.yield();
                System.out.println("��ǰ�߳�yield������ID:" + Thread.currentThread().getId() + "; i:" + i++);
            }
        }
    }
}
