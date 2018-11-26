package com.THR.DesignPatterns.命令模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Command宏命令接口实现——1
 */
public class MacroLtCommand implements MacroCommand {

    List<Command> commandList;

    public MacroLtCommand() {
        commandList = new ArrayList<>();
    }

    @Override
    public void addCommand(Command command) {
        commandList.add(command);
    }

    @Override
    public void removeCommand(Command command) {
        commandList.remove(command);
    }

    @Override
    public void execute() {
        for (Command command : commandList) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commandList) {
            command.undo();
        }
    }
}
