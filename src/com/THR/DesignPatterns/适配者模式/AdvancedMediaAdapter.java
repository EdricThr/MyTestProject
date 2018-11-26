package com.THR.DesignPatterns.������ģʽ;

/**
 * Adapter
 * ���˹۵㣺������������Ҳ����ʹ���ڲ��޸�Target�����߼�������£���Target��ԭ�еķ�����������������������
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
