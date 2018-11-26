package com.THR.Ïß³Ì.CompareThreadAndWait;

public class SleepCallThread implements Runnable {

    private SleepService sleepService;

    public SleepCallThread(SleepService sleepService) {
        this.sleepService = sleepService;
    }

    @Override
    public void run() {
        sleepService.doCallObject();
    }
}
