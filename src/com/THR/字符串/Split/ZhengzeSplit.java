package com.THR.×Ö·û´®.Split;

public class ZhengzeSplit {

    public static void main(String args[]){
        String str = "aaaa\r\nbbbb";
        //String array[] = str.split("\r?rr");
        String array[] = str.split("\r?\n");
        for (String s : array) {
            System.out.println(s);
        }
    }
}
