package com.THR.ThinkingInJava.类型信息.双重分派;

public class Client_ShuangChong {

    public static void main(String args[]){

        East east = new SubEast1();
        West west = new SubWest1();
        east.goEast(west);

        east = new SubEast2();
        west = new SubWest2();
        east.goEast(west);
    }
}
