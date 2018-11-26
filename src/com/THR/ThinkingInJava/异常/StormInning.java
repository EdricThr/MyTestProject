package com.THR.ThinkingInJava.异常;

public class StormInning extends MyException.Inning implements MyException.Storm {

    /**
     * 若基类构造器抛出异常，那么导出类构造器
     *     1.必须抛出其基类构造器抛出的异常（或者异常的基类异常）
     *     2.可以抛出其它异常，该异常可以和导出类抛出的异常无关
     *     3.如果基类只有一个构造器，且抛出了异常，即使导出类构造器和基类参数形式不同，也必须抛出对应异常
     */
    public StormInning() throws MyException.RainOut, MyException.BaseballException {
    }
    //即使方法参数不同，也需要抛出异常
    public StormInning(String s) throws MyException.BaseballException {
    }


    /**
     * 导出类重写方法时
     *      1.可仅抛出其基类方法抛出异常类的导出类异常（即可以抛出“小”异常）
     *      2.可以不抛出异常(如event()方法)
     */
    @Override
    public void atBat() throws MyException.Strike, MyException.PopFoul {

    }

    /**
     * 如果继承的类和接口有相同方法，但是抛出异常不同：
     *      1.由于重写方法异常规则，同时抛出方法的两个异常不可行
     *      2.最好的方式(不一定..)是不抛出异常 [苦笑....]
     *      3.或者抛出两种异常的子类[再次苦笑...]
     */
    @Override
    public void event() {

    }

    @Override
    public void rainHard() throws MyException.RainOut {

    }

    public static void main(String args[]){

        //try {
        //    StormInning si = new StormInning();
        //    si.atBat();
        //} catch (MyException.Strike strike) {
        //    strike.printStackTrace();
        //} catch (MyException.Foul foul) {
        //    foul.printStackTrace();
        //} catch (MyException.BaseballException e) {
        //    e.printStackTrace();
        //}
    }

}
