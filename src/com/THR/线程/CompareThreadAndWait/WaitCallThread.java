package com.THR.�߳�.CompareThreadAndWait;

public class WaitCallThread implements Runnable {

    private WaitService waitService;

    public WaitCallThread(WaitService waitService) {
        this.waitService = waitService;
    }

    @Override
    public void run() {
        waitService.doCallObject();
    }
}
