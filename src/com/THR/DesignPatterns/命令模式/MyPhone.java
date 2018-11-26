package com.THR.DesignPatterns.命令模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker 调用者，随时执行execute()方法
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


    //充当客户，创建具体的Command
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

        System.out.println("----------测试宏命令----------");
        /**
         * 未使用Invoker进行调用
         */
        MacroLtCommand macroLtCommand = new MacroLtCommand();
        macroLtCommand.addCommand(lightOnCommand);
        macroLtCommand.addCommand(tvOnCommand);
        macroLtCommand.execute();
    }
}
