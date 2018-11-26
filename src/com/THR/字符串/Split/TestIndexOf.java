package com.THR.×Ö·û´®.Split;

public class TestIndexOf {

    public static void main(String args[]){
        doIndexOf();
    }
    public static void doIndexOf() {
        String str=  "abc";
        int i = str.indexOf(";");
        String s1 = str.substring(0, i);
        String s2 = str.substring(i + 1);

    }

}
