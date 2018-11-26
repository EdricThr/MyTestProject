package com.THR.ThinkingInJava.Chapter_4;

public class This {

    private int i = 10;

    public int getI() {
        return i;
    }

    public static void doThigs(This tt) {
        tt.getI(); 
    }

    public void callThis(This tt) {
        System.out.println(tt.getI());
    }

    public void callThis() {
        i = 20;
        callThis(this);
    }

    public static void main(String args[]){
        This tt = new This();
        tt.callThis();
    }
}

