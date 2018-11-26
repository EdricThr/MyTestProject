package com.THR.DesignPatterns.������ģʽ;

public class Client_PlayMusic {
    public static void main(String args[]){
        MediaPlayer mediaPlayer = new Mp3Player();
        mediaPlayer.play("mp3", "����.mp3");
        //��ԭ��Target����ʵ�ֵĹ�����ǿ
        mediaPlayer.play("mp4", "��̫ƽ��.mp4");
        mediaPlayer.play("vcl", "UnKnown.vcl");

        //ֱ��ʹ�����������÷���
        MediaPlayer advancedPlayer = new AdvancedMediaAdapter();
        advancedPlayer.play("mp4", "��̫ƽ��.mp4");
        advancedPlayer.play("vcl", "UnKnown.vcl");
    }
}
