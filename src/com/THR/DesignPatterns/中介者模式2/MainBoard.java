package com.THR.DesignPatterns.中介者模式2;

public class MainBoard implements Mediator {

    private CDDriver cdDriver;
    private CPU cpu;
    private VideoCard videoCard;

    public void setCdDriver(CDDriver cdDriver) {
        this.cdDriver = cdDriver;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    @Override
    public void changed(Colleague c) {
        if (c instanceof CDDriver) {
            this.openCDDriverReadData((CDDriver) c);
        }else if (c instanceof CPU) {
            this.openCPU((CPU) c);
        }
    }

    private void openCDDriverReadData(CDDriver cd) {
        String data = cd.getData();
        cpu.executeData(data);
    }

    private void openCPU(CPU cpu) {
        String videoData = cpu.getVideoData();
        String soundData = cpu.getSoundData();

        videoCard.showData(videoData);
    }

}
