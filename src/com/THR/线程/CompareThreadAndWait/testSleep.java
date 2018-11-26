package com.THR.Ïß³Ì.CompareThreadAndWait;

public class testSleep {

    public static void main(String args[]){

        SleepService sleepService = new SleepService();

        Thread sleepThread = new Thread(new SleepThread(sleepService));
        Thread sleepCallObject = new Thread(new SleepCallThread(sleepService));

        sleepThread.start();
        sleepCallObject.start();
    }
}
