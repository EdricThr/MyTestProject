package com.THR.DesignPatterns.中介者模式3;

public class ZhongJie implements Mediator {

    private HouseOwner houseOwner;
    private Fangke fangke;

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public void setFangke(Fangke fangke) {
        this.fangke = fangke;
    }

    @Override
    public void constract(ZPerson zPerson) {
        if (zPerson instanceof  Fangke) {
            houseOwner.setComplay(((Fangke) zPerson).getAsk());
            houseOwner.speak();
        }else if (zPerson instanceof  HouseOwner) {

        }
    }
}
