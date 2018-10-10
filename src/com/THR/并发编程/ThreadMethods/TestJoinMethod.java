package com.THR.�������.ThreadMethods;

/**
 * ���ڲ����̵߳���join()����ʱ���������ͷ����
 *
 * @author Thr
 */
public class TestJoinMethod {

    private int i = 10;
    private Object object = new Object();


    public static void main(String args[]){
        try {
            doTestJoinMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * ͨ��������Կ�������
     *  1. �������̵߳��������̵߳�join()����ʱ, ������߼��������ִ��
     *  2. join(millis1) �� �߳�sleep(millis2)ʱ��ıȽ�
     *      1. > �߳�ִ����������������߼�
     *      2. < millis1�󣬿�ʼ����������߼�ִ��
     *�ɼ���
     *  ���̵߳�����A.join()��join(millis)�󣬵��ҽ���Aִ����ϻ�millisʱ��󣬲Ż����ִ����join�����µ��߼�������������̲߳���Ӱ�죬˭ֱ�ӵ��õı��˵ģ�˭���꣩
     * @throws InterruptedException
     */
    public static void doTestJoinMethod() throws InterruptedException {
        TestJoinMethod testBlockObjectStatus = new TestJoinMethod();
        MyJoinBlockTestThread myJoinBlockTestThread1 = testBlockObjectStatus.new MyJoinBlockTestThread();
        System.out.println("----------�߳�1 start-------------");
        myJoinBlockTestThread1.start();
        System.out.println("----------�߳�1 join��ʼ-------------");
        myJoinBlockTestThread1.join(15000);
        System.out.println("----------�߳�1 join����-------------");
        System.out.println("------------");
        System.out.println("------------");
        System.out.println("------------");
        System.out.println("------------");
        System.out.println("------------");
        MyJoinBlockTestThread myJoinBlockTestThread2 = testBlockObjectStatus.new MyJoinBlockTestThread();
        System.out.println("----------�߳��� �� �߳�2 start-------------");
        myJoinBlockTestThread2.start();
        myJoinBlockTestThread2.join();
        System.out.println("----------�߳��� �� �߳�2 end-------------");
    }

    class MyJoinBlockTestThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("��ǰ�߳�ID:" + Thread.currentThread().getId() + "; i:" + i++ + ",name��" + Thread.currentThread().getName());
                try {
                    System.out.println("-----" + Thread.currentThread().getName() +"����˯��------");
                    Thread.currentThread().sleep(40000);
                    System.out.println("-----" + Thread.currentThread().getName() +"����˯��------");
                } catch (InterruptedException e) {
                }
                System.out.println("��ǰ�߳�ID���н���:" + Thread.currentThread().getId() + "; i:" + i++ + ",name��" + Thread.currentThread().getName());
            }
        }
    }


}
