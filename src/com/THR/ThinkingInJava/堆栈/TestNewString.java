package com.THR.ThinkingInJava.¶ÑÕ»;

public class TestNewString {

    public static void main(String args[]){

        String aa = new String("abc");
        String bb = "abc";
        String cc = "abc";
        String dd = new String("abc");
        System.out.println(aa == bb);
        System.out.println(bb == cc);
        System.out.println(aa == dd);
        bb = "abc";
        System.out.println(bb == cc);
        bb = "aabbcc";
        System.out.println(bb == cc);
        System.out.println(bb);
        System.out.println(cc);
    }
}
