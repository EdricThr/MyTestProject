package com.THR.�߳�.CompareThreadAndWait;

public class WaitThread implements Runnable {

    private WaitService waitService;

    public WaitThread(WaitService waitService) {
         this.waitService = waitService;
    }

    @Override
    public void run() {
        waitService.doWait();
    }
}
