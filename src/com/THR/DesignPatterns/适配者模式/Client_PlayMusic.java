package com.THR.DesignPatterns.适配者模式;

public class Client_PlayMusic {
    public static void main(String args[]){
        MediaPlayer mediaPlayer = new Mp3Player();
        mediaPlayer.play("mp3", "南下.mp3");
        //对原有Target具体实现的功能增强
        mediaPlayer.play("mp4", "环太平洋.mp4");
        mediaPlayer.play("vcl", "UnKnown.vcl");

        //直接使用适配器调用方法
        MediaPlayer advancedPlayer = new AdvancedMediaAdapter();
        advancedPlayer.play("mp4", "环太平洋.mp4");
        advancedPlayer.play("vcl", "UnKnown.vcl");
    }
}
