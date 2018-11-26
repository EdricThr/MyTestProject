package com.THR.TheBeautyOfProgramming.One;

public class CPU {

    public static void main(String args[]){
        doTest2();
    }


    public static void doTest1()  throws InterruptedException {
        long busyTime = 10;
        while (true) {
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < busyTime) ;
            Thread.sleep(busyTime);
        }
    }
    public static void doTest2() {
        long time_start;
        int fulltime = 100;
        int runtime = 50;
        while (true) {
            time_start = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time_start) < fulltime) {
            }
            try {
                Thread.sleep(fulltime - runtime);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
