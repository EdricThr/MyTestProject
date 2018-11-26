package com.THR.DesignPatterns.抽象工厂模式;

/**
 * 抽象工厂面对多个产品族，工厂面对单个产品族
 * 两者都是延时到子类中去创建对象，但抽象工厂创建多个特定的产品对象，工厂创建单个不确定的产品对象
 */
public interface AbstractFactory {
    Cpu createCpu();
    Mainboard createMainboard();
}
