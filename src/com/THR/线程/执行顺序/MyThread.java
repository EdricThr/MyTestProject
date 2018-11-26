package com.THR.线程.执行顺序;

import java.util.Timer;
import java.util.TimerTask;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("-----线程执行方法-----");
        new Timer().schedule(new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                System.out.println("-----线程执行方法-----" + i++);
            }
        },0, 1000);
    }
}
