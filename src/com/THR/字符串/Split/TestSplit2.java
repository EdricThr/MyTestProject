package com.THR.×Ö·û´®.Split;

public class TestSplit2 {

    public static void main(String args[]){
        StringBuilder builder = new StringBuilder();
        String str = "111;222;";
        String ss[] = str.split(";");
        System.out.println(ss.length);
        for (String s : ss){
            builder.append(s+";");
            builder.append("\n");
        }

        System.out.println(builder.toString());
        System.out.println("------------------");
        System.out.println(str.indexOf(";"));
        System.out.println(str.substring(0,str.indexOf(";")));
        System.out.println(str.substring(0,0) + "---");
    }
}
