package com.THR.DesignPatterns.不知名模式1;

public abstract class AbstractConfirm implements IConfirm {

    @Override
    public void doVoice(ConfirmChain confirmChain) {
        voice();
        confirmChain.doSpeak();
    }


    public abstract void voice();
}
