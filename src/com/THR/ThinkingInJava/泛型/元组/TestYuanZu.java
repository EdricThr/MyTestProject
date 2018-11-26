package com.THR.ThinkingInJava.·ºÐÍ.Ôª×é;

public class TestYuanZu {
    public static void main(String args[]){
        TwoTuple<String, Integer> twoTuple = new TwoTuple<>("THR", 24);
        System.out.println(twoTuple.toString());

        twoTuple = new ThreeTyple<>("ABC", 25, "hahaha");
        System.out.println(twoTuple.toString());
    }
}