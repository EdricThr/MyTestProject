package com.THR.DesignPatterns.����ģʽ;

/**
 * Command������ӿ�
 */
public interface MacroCommand extends Command {

    void addCommand(Command command);
    void removeCommand(Command command);
}
