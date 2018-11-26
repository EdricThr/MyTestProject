package com.THR.DesignPatterns.模板模式;

public abstract class AbstractMethod {

    /**
     * 抽象模板方法
     * 顶级逻辑/顶级行为
     * 子类可以置换掉父类的可变部分，但是子类却不可以改变模板方法所代表的顶级逻辑
     */
    public final void templateMethod() {
        //模板调用基本方法
        abstractMethod();
        hookMethod();
        concreteMethod();
    }

    /**
     * 基本方法声明(由子类实现其自己的逻辑)
     */
    protected abstract void abstractMethod();

    /**
     * 基本方法，空方法，子类也可重写
     */
    protected void hookMethod() {

    }

    /**
     * 基本方法(已经实现)
     */
    private final void concreteMethod() {
        //父类自己的业务逻辑
    }
}
