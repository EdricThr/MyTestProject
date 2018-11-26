package com.THR.»ù´¡;

public class TestFinal{

    public static void main(String args[]){
        final String a = "hello";
        String b = "hello2";
        String c = a + 2;
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(c==b);
        String d = "hello2";
        System.out.println(b==d);
    }
}
