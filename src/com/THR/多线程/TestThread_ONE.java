package com.THR.���߳�;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread_ONE {
    public static void main(String args[]){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        for (int i =0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("�̳߳����߳���Ŀ��" + executor.getPoolSize() +
                    "�������� ��¼ִ���������� " + executor.getQueue().size() +
            "����ִ����ɵ�������Ŀ�� " + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
    static class MyTask implements Runnable {

        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            System.out.println("����ִ��task " + taskNum);
            try {
                Thread.currentThread().sleep(4000);
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + " ִ�����");
        }
    }
}
