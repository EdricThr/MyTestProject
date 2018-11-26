package com.THR.×Ö·û´®;


import com.base.util.StringUtil;

public class TestSplit {

    public static void main(String args[]){
        testSplit2();
    }

    public static void testSplit(){
        String str = ";99;999;99;";
        String[] strs = str.split(";");

        System.out.println(strs.length);
        for (String ss : strs){
            System.out.println(StringUtil.isEmpty(ss));
            System.out.println(ss);
        }
        Integer ii = null;
        System.out.println(String.valueOf(ii));
        //System.out.println(ii.toString().equals("22222"));

        String ttt = null;
        System.out.println(ttt);
    }

    public static void testSplit2(){
        String str = ".99.999.99.";
        String[] strs = str.split("\\.");

        System.out.println(strs.length);
        for (String ss : strs){
            System.out.println(StringUtil.isEmpty(ss));
            System.out.println(ss);
        }
        Integer ii = null;
        System.out.println(String.valueOf(ii));
        //System.out.println(ii.toString().equals("22222"));
    }
}
