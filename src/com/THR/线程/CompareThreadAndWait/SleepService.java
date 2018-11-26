package com.THR.Ïß³Ì.CompareThreadAndWait;

public class SleepService {

    public void doSleep(){
        synchronized (this) {
            System.out.println("start------doSleep()-------" + System.currentTimeMillis() / 1000);
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("end------doSleep()-------" + System.currentTimeMillis() / 1000);
        }
    }
    public void doCallObject() {
        synchronized (this) {
            System.out.println("-----doClassObject()------" + System.currentTimeMillis() / 1000);
        }
    }

}
