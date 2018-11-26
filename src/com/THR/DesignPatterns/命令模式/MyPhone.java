package com.THR.DesignPatterns.����ģʽ;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker �����ߣ���ʱִ��execute()����
 */
public class MyPhone {
    List<Command> commandList;
    public MyPhone() {
        commandList = new ArrayList<>();
    }

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void onButtonClicked(int i){
        commandList.get(i).execute();
    }


    //�䵱�ͻ������������Command
    public static void main(String args[]){
        MyPhone myPhone = new MyPhone();

        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);

        TV tv = new TV();
        Command tvOnCommand = new TvOnCommand(tv);

        myPhone.addCommand(lightOnCommand);
        myPhone.addCommand(tvOnCommand);

        myPhone.onButtonClicked(0);
        myPhone.onButtonClicked(1);

        System.out.println("----------���Ժ�����----------");
        /**
         * δʹ��Invoker���е���
         */
        MacroLtCommand macroLtCommand = new MacroLtCommand();
        macroLtCommand.addCommand(lightOnCommand);
        macroLtCommand.addCommand(tvOnCommand);
        macroLtCommand.execute();
    }
}
