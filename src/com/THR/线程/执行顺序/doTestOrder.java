package com.THR.�߳�.ִ��˳��;

import java.util.Timer;
import java.util.TimerTask;

public class doTestOrder {

    public static void main(String args[]){
        System.out.println("-----���߳�ִ�з���start-----");
        new Thread(new MyThread()).start();
        System.out.println("-----���߳�ִ�з���end-----");
        new Timer().schedule(new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                System.out.println("-----���߳�ִ�з���-----" + i++);
            }
        },0, 1000);
    }
}
