package com.THR.定时任务.ScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class testScheduledExecutorService {

    public static void main(String args[]){
        ScheduledExecutorService mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        //只会执行一次
        mScheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("-----------------");
            }
        }, 1, TimeUnit.SECONDS);

        /*
        * 按照网上的说法，循环任务，以上次循环开始后开始计算时间间隔。
        * 按照实际的程序运行结果，如果程序耗时大于period，则程序运行结束就会执行下一次循环;
        *                      如果程序耗时小于period，则程序会在period之后进行下一次循环。
        *
        *  综合来看：使用scheduleAtFixedRate进行程序的循环执行，下一次循环会在上一次执行结束后执行，且耗时肯定大于或者等于period
        * */
        mScheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("start----scheduleAtFixedRate----" + System.currentTimeMillis() / 1000);
                try {
                    Thread.sleep(4000);
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("end----scheduleAtFixedRate----" + System.currentTimeMillis() / 1000);
            }
        }, 1, 2, TimeUnit.SECONDS);

        /*
        * 按照网上的说法：循环任务，以上次循环结束后开始计算时间间隔
        * 按照程序的运行结果：两个循环任务的时间间隔 = 循环任务耗时 + period
        * */
        mScheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("----scheduleWithFixedDelay----" + System.currentTimeMillis() / 1000);
                try {
                    Thread.sleep(4000);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
