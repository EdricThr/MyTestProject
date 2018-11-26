package com.THR.DesignPatterns.适配者模式;

/**
 * Adapter
 * 个人观点：适配器的作用也就是使得在不修改Target本身逻辑的情况下，让Target在原有的方法中做其他对象能做的事
 */
public class AdvancedMediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    @Override
    public void play(String audioType, String fileName) {
        if ("VCL".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new VclPlayer();
        }else if ("MP4".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new Mp4Player();
        }

        if (null != advancedMediaPlayer) {
            advancedMediaPlayer.playMusic(fileName);
        }
    }
}
