package com.THR.DesignPatterns.��֪��ģʽ1;

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
            System.out.println("ִ�����");
            return;
        }
        IConfirm iSpeak = confirmList.get(index);
        index ++;
        System.out.println("����ִ�е�" + index + "��confirm");
        iSpeak.doVoice(this);
    }

}
