package com.THR.定时任务.Timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class testTimer {

    public static void main(String args[]){

        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------run one time------" + System.currentTimeMillis() / 1000);
            }
        };

        //设置准确的时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 12);
        calendar.set(Calendar.SECOND, 0);
        Date date = calendar.getTime();
        System.out.println(date);
        System.out.println(new Date().before(date));

        /**
         * schedule方法有四种重载形式
         * 1.可以设置在一定延时时间之后执行
         * 2.也可以在延时之后每隔一个period执行一次
         * 3.可以设置在固定的时间点(date)执行
         * 4.也可以设置在固定的时间点执行之后，每隔一个period执行一次
         * 注：3和4 可以判断和现在时间的大小，然后将第一次执行的时间 + 1天
         */

        //timer.schedule(timerTask, date);
        //timer.schedule(timerTask, date, 2000);

        //timer.schedule(timerTask, 1000);
        timer.schedule(timerTask, 1000, 2000);

        /**
         *scheduleAtFixedRate 有两种重载形式
         * 1.可以设置首次执行延时
         * 2.可以设置首次执行时间
         *
         * 对于 schedule 和 scheduleAtFixedRate 的区别：
         * 网上说，schedule是按照上次任务完成时间开始计算时间间隔，
         *       而scheduleAtFixedRate按照上次任务开始时间开始计算
         * 亲测：两者都是按照上次任务开始时间计算时间间隔，类似于ScheduledExecutorService.scheduleAtFixedRate()
         *
         */
        //timer.scheduleAtFixedRate(timerTask, 1000, 2000);
        //timer.scheduleAtFixedRate(timerTask, date, 2000);
    }

}
