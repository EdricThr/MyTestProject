package com.THR.ThinkingInJava.∂‡Ã¨;

public class TestZhuanXing {

    public static void main(String args[]){
        People pp[] = new People[]{
                new People(),
                new Son(),
        };
        pp[0].p();
        pp[1].p();
        //((Son)pp[0]).s();
        ((Son)pp[1]).s();
    }
}
