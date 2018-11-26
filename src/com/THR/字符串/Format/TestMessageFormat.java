package com.THR.×Ö·û´®.Format;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestMessageFormat {

    public static void main(String args[]) throws Exception {

        doTestSimpleDateFormat();

    }

    private static void doTestSimpleDateFormat() throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String timeFormat = simpleDateFormat.format(date);
        System.out.println(timeFormat);
        System.out.println(simpleDateFormat.parse(timeFormat));
        System.out.println(date);
    }


    private static void doTestDateFormat() {
        Date date = new Date();
        DateFormat format = DateFormat.getDateInstance();
        System.out.println("DateFormat.getDateInstance(): "  + format.format(date));

        format = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
        System.out.println("DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA): "  + format.format(date));

        format = DateFormat.getTimeInstance();
        System.out.println("DateFormat.getTimeInstance(): "  + format.format(date));

        format = DateFormat.getTimeInstance(DateFormat.SHORT);
        System.out.println("DateFormat.getTimeInstance(DateFormat.SHORT): "  + format.format(date));


        format = DateFormat.getDateTimeInstance();
        System.out.println("DateFormat.getDateTimeInstance(): "  + format.format(date));

        format = DateFormat.getInstance();
        System.out.println("DateFormat.getInstance(): "  + format.format(date));
    }


    private static void doTestMessageFormat() {
        String str = MessageFormat.format("i am {0},{1}","a", "b");
        System.out.println(str);
        str = MessageFormat.format("i am {0},{1}","a");
        System.out.println(str);
    }
}
