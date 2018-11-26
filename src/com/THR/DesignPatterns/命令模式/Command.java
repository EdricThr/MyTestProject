package com.THR.DesignPatterns.命令模式;

/**
 * Command 命令接口
 */
public interface Command {
    void execute();
    void undo();
}
