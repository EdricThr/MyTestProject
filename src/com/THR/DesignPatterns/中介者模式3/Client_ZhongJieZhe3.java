package com.THR.DesignPatterns.中介者模式3;

public class Client_ZhongJieZhe3 {

    public static void main(String args[]){

        ZhongJie mediator = new ZhongJie();
        Fangke fangke = new Fangke(mediator);
        HouseOwner houseOwner = new HouseOwner(mediator);
        mediator.setFangke(fangke);
        mediator.setHouseOwner(houseOwner);

        fangke.apply("我想租一套房子，请问你有房源吗？");
    }
}
