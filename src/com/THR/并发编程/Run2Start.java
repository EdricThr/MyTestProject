package com.THR.�������;

/**
 * Thread �� run() ���� �� Thread() ������
 *
 * @author Thr
 */
public class Run2Start {

    /**
     * ��������������ʱ�����������£�
         ��ǰ�̺߳ţ�1
         -------->run()  ��1�� �߳�, �̺߳ţ�1
         -------->run()  ��2�� �߳�, �̺߳ţ�1
         -------->run()  ��3�� �߳�, �̺߳ţ�1
         -------->run()  ��6�� �߳�, �̺߳ţ�12
         -------->run()  ��6�� �߳�, �̺߳ţ�13
         -------->run()  ��6�� �߳�, �̺߳ţ�14
     �������������ʱ��������£�
         ��ǰ�̺߳ţ�1
         -------->run()  ��1�� �߳�, �̺߳ţ�1
         -------->run()  ��2�� �߳�, �̺߳ţ�1
         -------->run()  ��3�� �߳�, �̺߳ţ�1
         -------->run()  ��4�� �߳�, �̺߳ţ�14
         -------->run()  ��5�� �߳�, �̺߳ţ�15
         -------->run()  ��6�� �߳�, �̺߳ţ�16
     �����Ͽ��Կ�����
        1. ֱ�ӵ����½��̵߳�run�������̻߳ᴴ����������ͨ�����߳����У����̺���ͨ����������ͬ��
        2. �����½��̵߳�start()��������ʹ���½��̵߳���run()����
        3. �����������к͵�������ʱ�������run()�����е� �� n �� �� n ��ͬ��Ӧ������Ϊ���������й��죬
            ���߳�ȫ��������ɺ����̵߳ķ����ſ�ʼ½��ִ��
     * @param args
     */
    public static void main(String args[]){

        System.out.println("��ǰ�̺߳ţ�" + Thread.currentThread().getId());
        Thread thread1 = new MyThread();
        thread1.run();
        Thread thread2 = new MyThread();
        thread2.run();
        Thread thread3 = new MyThread();
        thread3.run();

        Thread thread4 = new MyThread();
        thread4.start();
        Thread thread5 = new MyThread();
        thread5.start();
        Thread thread6 = new MyThread();
        thread6.start();
    }
}
