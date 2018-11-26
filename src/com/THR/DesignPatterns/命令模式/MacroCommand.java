package com.THR.DesignPatterns.命令模式;

/**
 * Command宏命令接口
 */
public interface MacroCommand extends Command {

    void addCommand(Command command);
    void removeCommand(Command command);
}
