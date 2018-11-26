package com.THR.DesignPatterns.命令模式;

/**
 * Concrete Command-2 具体命令
 */
public class TvOnCommand implements Command {

    private TV tv;
    public TvOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
