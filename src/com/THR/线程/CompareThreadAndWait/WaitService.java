package com.THR.Ïß³Ì.CompareThreadAndWait;

public class WaitService {

    public void doWait(){
        synchronized (this) {
            System.out.println("start------wait()-------" + System.currentTimeMillis() / 1000);
            try {
                this.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("end------wait()-------" + System.currentTimeMillis() / 1000);
        }
    }
    public void doCallObject() {
        synchronized (this) {
            System.out.println("-----wait()------" + System.currentTimeMillis() / 1000);
        }
    }

}
