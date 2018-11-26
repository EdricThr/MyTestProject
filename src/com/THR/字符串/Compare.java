package com.THR.×Ö·û´®;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compare {

    public static void main(String args[]){
        String str1 = "192.168.42.2";
        String str2 = "192.168.42.9";
        String str3 = "192.168.42.220";

        str1 = str1.replaceAll("(\\d+)", "00$1");
        str1 = str1.replaceAll("0*(\\d{3})", "$1");

        str2 = str2.replaceAll("(\\d+)", "00$1").replaceAll("0*(\\d{3})", "$1");

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3.compareTo(str1));
        System.out.println(str3.compareTo(str2));



        String readReplyContent = StringUtils.replace("abbcccdddd","bbb","BB");
        System.out.println(readReplyContent);

        String abc = new String(new char[]{'a','b','c','d','e'}, 2,3);
        System.out.println(abc);
        abc = "abcde".substring(2, 5);
        System.out.println(abc);
    }
    public static void compareTime() throws Exception {

        Date date= new Date(System.currentTimeMillis());
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String parse = dateFormat.format(date);
        System.out.println("--------"+parse);

        parse = dateFormat.format(new Date());
        System.out.println("--------"+parse);

        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date dt1 = df.parse("12:00:00");
        Date dt2 = df.parse("13:00:00");
        System.out.println("-----" + dt1.toString());
        System.out.println(dt1.getTime() > dt2.getTime());
    }

}
