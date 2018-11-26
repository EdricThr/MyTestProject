package com.THR.Ïß³Ì.CompareThreadAndWait;

public class testWait {

    public static void main(String args[]){

        WaitService waitService = new WaitService();

        Thread waitThread = new Thread(new WaitThread(waitService));
        Thread waitCallObject = new Thread(new WaitCallThread(waitService));

        waitThread.start();
        waitCallObject.start();
    }
}
