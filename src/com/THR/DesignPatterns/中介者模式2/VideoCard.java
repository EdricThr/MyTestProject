package com.THR.DesignPatterns.�н���ģʽ2;

public class VideoCard extends Colleague {

    public VideoCard(Mediator mediator) {
        super(mediator);
    }

    public void showData(String data) {
        System.out.println("�����������տ����ǣ�" + data);
    }
}
