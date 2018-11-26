package com.THR.ThinkingInJava.异常;


/**
 * 验证异常的限制  p269
 */
public class MyException {
    class BaseballException extends Exception {
    }
    class Foul extends BaseballException {
    }
    static abstract class Inning {
        public Inning() throws BaseballException {

        }
        public void event() throws BaseballException {

        }
        public abstract void atBat() throws Strike, Foul;
        public void walk() {}
    }
    class Strike extends BaseballException {
    }

    class StormException extends Exception {

    }
    class RainOut extends StormException {

    }
    class PopFoul extends Foul {

    }

    interface Storm {
        void event() throws RainOut;
        void rainHard() throws RainOut;
    }
}
