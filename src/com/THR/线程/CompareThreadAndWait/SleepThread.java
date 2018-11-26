package com.THR.Ïß³Ì.CompareThreadAndWait;

public class SleepThread implements Runnable {

    private SleepService sleepService;

    public SleepThread(SleepService sleepService) {
         this.sleepService = sleepService;
    }

    @Override
    public void run() {
        sleepService.doSleep();
    }
}
