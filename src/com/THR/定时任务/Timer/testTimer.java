package com.THR.��ʱ����.Timer;

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

        //����׼ȷ��ʱ��
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 12);
        calendar.set(Calendar.SECOND, 0);
        Date date = calendar.getTime();
        System.out.println(date);
        System.out.println(new Date().before(date));

        /**
         * schedule����������������ʽ
         * 1.����������һ����ʱʱ��֮��ִ��
         * 2.Ҳ��������ʱ֮��ÿ��һ��periodִ��һ��
         * 3.���������ڹ̶���ʱ���(date)ִ��
         * 4.Ҳ���������ڹ̶���ʱ���ִ��֮��ÿ��һ��periodִ��һ��
         * ע��3��4 �����жϺ�����ʱ��Ĵ�С��Ȼ�󽫵�һ��ִ�е�ʱ�� + 1��
         */

        //timer.schedule(timerTask, date);
        //timer.schedule(timerTask, date, 2000);

        //timer.schedule(timerTask, 1000);
        timer.schedule(timerTask, 1000, 2000);

        /**
         *scheduleAtFixedRate ������������ʽ
         * 1.���������״�ִ����ʱ
         * 2.���������״�ִ��ʱ��
         *
         * ���� schedule �� scheduleAtFixedRate ������
         * ����˵��schedule�ǰ����ϴ��������ʱ�俪ʼ����ʱ������
         *       ��scheduleAtFixedRate�����ϴ�����ʼʱ�俪ʼ����
         * �ײ⣺���߶��ǰ����ϴ�����ʼʱ�����ʱ������������ScheduledExecutorService.scheduleAtFixedRate()
         *
         */
        //timer.scheduleAtFixedRate(timerTask, 1000, 2000);
        //timer.scheduleAtFixedRate(timerTask, date, 2000);
    }

}
