package com.THR.ThinkingInJava.类型信息.双重分派2;

public class Client_ShuangChong2 {

    public static void main(String args[]){
        TEast east = new TSubEast1();
        TWest west = new TSubWest1();
        east.goEast(west);
    }
}
