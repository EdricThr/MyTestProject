package com.THR.��ʱ����.ScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class testScheduledExecutorService {

    public static void main(String args[]){
        ScheduledExecutorService mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        //ֻ��ִ��һ��
        mScheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("-----------------");
            }
        }, 1, TimeUnit.SECONDS);

        /*
        * �������ϵ�˵����ѭ���������ϴ�ѭ����ʼ��ʼ����ʱ������
        * ����ʵ�ʵĳ������н������������ʱ����period����������н����ͻ�ִ����һ��ѭ��;
        *                      ��������ʱС��period����������period֮�������һ��ѭ����
        *
        *  �ۺ�������ʹ��scheduleAtFixedRate���г����ѭ��ִ�У���һ��ѭ��������һ��ִ�н�����ִ�У��Һ�ʱ�϶����ڻ��ߵ���period
        * */
        mScheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("start----scheduleAtFixedRate----" + System.currentTimeMillis() / 1000);
                try {
                    Thread.sleep(4000);
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("end----scheduleAtFixedRate----" + System.currentTimeMillis() / 1000);
            }
        }, 1, 2, TimeUnit.SECONDS);

        /*
        * �������ϵ�˵����ѭ���������ϴ�ѭ��������ʼ����ʱ����
        * ���ճ�������н��������ѭ�������ʱ���� = ѭ�������ʱ + period
        * */
        mScheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("----scheduleWithFixedDelay----" + System.currentTimeMillis() / 1000);
                try {
                    Thread.sleep(4000);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
