package com.THR.�������.ThreadMethods;

/**
 * @author Thr
 */
public class TestInterruptMethod {

    private Object object = new Object();
    private int i = 10;


    public static void main(String args[]){
        //testInterruptBlockThread();
        testInterruptNoneBlockThread();
    }


    /**
     * ����Interrupt���������߳�
     *  �������������£�
     *       main��ʼ˯��....
             ��ǰ�߳�ID:9; name:Thread-0
             ��ʼ����˯��...
             main����˯��....
             ----1----
             ˯�߱��ж�
             ��ǰ�߳̽�����ID:9; name:Thread-0
             ----2----
        �ɼ����������� thread.interrupt(); ��thread������״̬����ֹ�������������С���ˣ�interrupt()�������������������״̬���߳�
     */
    public static void testInterruptBlockThread() {
        TestInterruptMethod testInterruptMethod = new TestInterruptMethod();
        MyInterruptBlockTestThread thread = testInterruptMethod.new MyInterruptBlockTestThread();
        thread.start();
        try {
            System.out.println(Thread.currentThread().getName() + "��ʼ˯��....");
            Thread.currentThread().sleep(1000);
            System.out.println(Thread.currentThread().getName() + "����˯��....");
        } catch (InterruptedException e) {

        }
        System.out.println("----1----");
        thread.interrupt();
        System.out.println("----2----");
    }

    class MyInterruptBlockTestThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("��ǰ�߳�ID:" + Thread.currentThread().getId() + "; name:" + Thread.currentThread().getName());
                try {
                    System.out.println("��ʼ����˯��...");
                    Thread.currentThread().sleep(10000);
                    System.out.println("˯�߽���...");
                } catch (InterruptedException e) {
                    System.out.println("˯�߱��ж�");
                }
                System.out.println("��ǰ�߳̽�����ID:" + Thread.currentThread().getId() + "; name:" + Thread.currentThread().getName());
            }
        }
    }

    /**
     * ����Interrupt���������߳�
     *  �������������£�
     *       main��ʼ˯��....
             ��ǰ�߳�ID:9; name:Thread-0
             1000000, 2000000, 3000000, 4
             ----1----
             ----2----
             122000000, 123000000, 124000
             ��ǰ�߳̽�����ID:9; name:Thread-0


     �ɼ����������� thread.interrupt(); ���̵߳��߼���û�б��жϣ����Ǽ���ִ��ѭ������ˣ�interrupt()�����������������������״̬���̣߳�thread�������������״̬�򲻻ᱻ�жϣ��̼߳���ԭ�е��߼�ִ��
        Thread��ķ��� isInterrupted() ���Է����̵߳��ж�λ������̵߳�����interrupt()֮�󣬸÷�������true; ��ˣ�������ʹ��interrupt()�жϷ�����߳�ʱ������ʹ�� isInterrupted()�������������ж�
        ͬ����������һ���������߳��ṩ�ⲿ�޸ĸñ����ķ��������߳��ڲ����ݸñ���ȷ���Ƿ���м���ִ���߳�
     */
    public static void testInterruptNoneBlockThread() {
        TestInterruptMethod testInterruptNoneMethod = new TestInterruptMethod();
        MyInterruptNoneBlockTestThread thread = testInterruptNoneMethod.new MyInterruptNoneBlockTestThread();
        thread.start();
        try {
            System.out.println(Thread.currentThread().getName() + "��ʼ˯��....");
            Thread.currentThread().sleep(1000);
            System.out.println(Thread.currentThread().getName() + "����˯��....");
        } catch (InterruptedException e) {

        }
        System.out.println("----1----");
        thread.interrupt();
        System.out.println("----2----");
    }

    class MyInterruptNoneBlockTestThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("��ǰ�߳�ID:" + Thread.currentThread().getId() + "; name:" + Thread.currentThread().getName());
                int i = 0;
                while (i < 390000000) {
                //while (!isInterrupted() && i < 390000000) {
                    if ((++i) % 1000000 == 0) {
                        System.out.print(i + ", ");
                    }
                    if (i % 1000000000 == 0) {
                        System.out.println();
                    }
                }
                System.out.println();
                System.out.println("��ǰ�߳̽�����ID:" + Thread.currentThread().getId() + "; name:" + Thread.currentThread().getName());
            }
        }
    }
}
