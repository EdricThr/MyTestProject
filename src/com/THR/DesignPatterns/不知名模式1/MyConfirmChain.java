package com.THR.DesignPatterns.不知名模式1;

import java.util.ArrayList;
import java.util.List;

public class MyConfirmChain implements ConfirmChain {

    private int index = 0;

    private List<IConfirm> confirmList = new ArrayList<>();
    public MyConfirmChain() {
        confirmList.add(new ConfirmAImpl());
        confirmList.add(new ConfirmBImpl());
    }

    @Override
    public void doSpeak() {
        if (index >= confirmList.size()) {
            System.out.println("执行完毕");
            return;
        }
        IConfirm iSpeak = confirmList.get(index);
        index ++;
        System.out.println("正在执行第" + index + "次confirm");
        iSpeak.doVoice(this);
    }

}
