package com.THR.线程.执行顺序;

import java.util.Timer;
import java.util.TimerTask;

public class doTestOrder {

    public static void main(String args[]){
        System.out.println("-----主线程执行方法start-----");
        new Thread(new MyThread()).start();
        System.out.println("-----主线程执行方法end-----");
        new Timer().schedule(new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                System.out.println("-----主线程执行方法-----" + i++);
            }
        },0, 1000);
    }
}
