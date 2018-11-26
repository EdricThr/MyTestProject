package com.THR.DesignPatterns.适配者模式;

public class Mp3Player implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if ("MP3".equalsIgnoreCase(audioType)) {
            System.out.println("Playing Mp3 file,fileName:" + fileName);
        }
        //也可以在Target的具体实现下使用适配器，让具体实现获得更多功能
        else {
            AdvancedMediaAdapter advancedMediaAdapter = new AdvancedMediaAdapter();
            advancedMediaAdapter.play(audioType, fileName);
        }
    }
}
