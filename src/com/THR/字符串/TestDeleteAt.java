package com.THR.×Ö·û´®;

public class TestDeleteAt {

    public static void main(String args[]){
        StringBuilder sb = new StringBuilder("abcdefg,or");
        //sb.deleteCharAt(sb.length() - 1);
        //sb.delete(2, 4);
        sb.delete(sb.length() - "or".length(), sb.length());
        System.out.println(sb.toString());
    }
}
