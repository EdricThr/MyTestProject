package com.THR.�ճ�;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Thr
 */
public class DateForm {

    public static void main(String args[]) throws ParseException {

        //����Ҫ���Ĳ���
        String str = new Date().toString();
        SimpleDateFormat sm = new SimpleDateFormat("EEE MMM dd HH:mm:ss", Locale.ENGLISH);
        Date date = sm.parse(str);

        //��֮ǰ�ĳ���
        //Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(date);
        Date date1 = dateFormat.parse(dateStr);
        System.out.println("date1: " + date1);
    }
}
