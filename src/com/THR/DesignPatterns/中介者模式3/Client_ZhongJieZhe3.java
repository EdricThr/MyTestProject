package com.THR.DesignPatterns.�н���ģʽ3;

public class Client_ZhongJieZhe3 {

    public static void main(String args[]){

        ZhongJie mediator = new ZhongJie();
        Fangke fangke = new Fangke(mediator);
        HouseOwner houseOwner = new HouseOwner(mediator);
        mediator.setFangke(fangke);
        mediator.setHouseOwner(houseOwner);

        fangke.apply("������һ�׷��ӣ��������з�Դ��");
    }
}
