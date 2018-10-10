package com.THR.»’≥£;

/**
 * @author Thr
 */
public class DelteStringBuilder {

    public static void main(String args[]){
        StringBuilder builder = new StringBuilder();
        builder.append("abcd");
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }
}
