package com.THR.DataStructure.Lesson_One;

public class CircleN {

    public static void main(String args[]){
        long startTime1 = System.currentTimeMillis();
        MethodOne(100000);
        System.out.println("ºÄÊ±£º" + (System.currentTimeMillis() - startTime1));
        long startTime2 = System.currentTimeMillis();
        MethodTwo(100000);
        System.out.println("ºÄÊ±£º" + (System.currentTimeMillis() - startTime2));
    }

    public static void MethodOne(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + ",");
        }
    }

    public static void MethodTwo(int n) {
        if (n > 0) {
            MethodTwo(n - 1);
            System.out.print(n + ",");
        }
    }

}
