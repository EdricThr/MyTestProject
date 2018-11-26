package com.THR.DesignPatterns.������ģʽ;

public class Mp3Player implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if ("MP3".equalsIgnoreCase(audioType)) {
            System.out.println("Playing Mp3 file,fileName:" + fileName);
        }
        //Ҳ������Target�ľ���ʵ����ʹ�����������þ���ʵ�ֻ�ø��๦��
        else {
            AdvancedMediaAdapter advancedMediaAdapter = new AdvancedMediaAdapter();
            advancedMediaAdapter.play(audioType, fileName);
        }
    }
}
