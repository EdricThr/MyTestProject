package com.THR.�������.ThreadMethods;

/**
 * @author Thr
 */
public class TestSleepMethod {

    private Object object = new Object();
    private int i = 10;


    public static void main(String args[]){
        doTestSleepMethod();
    }


    /**
     * ����Thread.sleep()����
     * ������������������н�����£�
     ��ǰ�߳�ID:9; i:10
     ��ǰ�߳�ID:10; i:11
     �߳̿�ʼ����sleep()
     �߳̿�ʼ����sleep()
     ��ǰ�߳�sleep������ID:10; i:13
     ��ǰ�߳�sleep������ID:9; i:12
     * ������������������£�
     ��ǰ�߳�ID:9; i:10
     �߳̿�ʼ����sleep()
     ��ǰ�߳�sleep������ID:9; i:11
     ��ǰ�߳�ID:10; i:12
     �߳̿�ʼ����sleep()
     ��ǰ�߳�sleep������ID:10; i:13

     ���Կ�����
     1. sleep()��������Thread�࣬����Ҫ���쳣���м��
     2. �̵߳���sleep()�����������ͷŶ������
     3. ��֪����sleep()ʱ��������̲߳�һ��������ִ�У���ǰCPU������ִ������������
     (����sleep()�������߳̽�������(׼ȷ˵��time waiting)״̬�����滹����Ҫ��������״̬����һ�������̵õ�CPUʱ��)
     */
    public static void doTestSleepMethod() {
        TestSleepMethod sleepMethod = new TestSleepMethod();
        sleepMethod.new MySleepBlockTestThread().start();
        sleepMethod.new MySleepBlockTestThread().start();
    }

    class MySleepBlockTestThread extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println("��ǰ�߳�ID:" + Thread.currentThread().getId() + "; i:" + i++);
                try {
                    System.out.println("�߳̿�ʼ����sleep()");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("��ǰ�߳�sleep������ID:" + Thread.currentThread().getId() + "; i:" + i++);
            }
        }
    }
}
