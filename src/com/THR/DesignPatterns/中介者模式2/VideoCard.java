package com.THR.DesignPatterns.中介者模式2;

public class VideoCard extends Colleague {

    public VideoCard(Mediator mediator) {
        super(mediator);
    }

    public void showData(String data) {
        System.out.println("您现在正在收看的是：" + data);
    }
}
