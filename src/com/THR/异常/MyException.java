package com.THR.“Ï≥£;

/**
 * @author Thr
 */
public class MyException extends BaseException{
    public MyException(String msg, String code, Throwable t) {
        super(msg, code, t);
    }

    public MyException(String msg, String code) {
        super(msg, code);
    }

    public MyException(String msg) {
        super(msg);
    }
}
