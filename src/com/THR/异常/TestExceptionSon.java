package com.THR.�쳣;

/**
 * @author Thr
 */
public class TestExceptionSon extends TestException {

    @Override
    public void doThrowException() {
        throw new MyException("");
    }
}
