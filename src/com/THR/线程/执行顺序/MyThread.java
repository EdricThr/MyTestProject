package com.THR.�߳�.ִ��˳��;

import java.util.Timer;
import java.util.TimerTask;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("-----�߳�ִ�з���-----");
        new Timer().schedule(new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                System.out.println("-----�߳�ִ�з���-----" + i++);
            }
        },0, 1000);
    }
}
