package com.THR.日常;

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

        //你需要做的部分
        String str = new Date().toString();
        SimpleDateFormat sm = new SimpleDateFormat("EEE MMM dd HH:mm:ss", Locale.ENGLISH);
        Date date = sm.parse(str);

        //我之前的程序
        //Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(date);
        Date date1 = dateFormat.parse(dateStr);
        System.out.println("date1: " + date1);
    }
}
