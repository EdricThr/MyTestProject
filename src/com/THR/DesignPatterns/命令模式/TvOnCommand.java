package com.THR.DesignPatterns.����ģʽ;

/**
 * Concrete Command-2 ��������
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
