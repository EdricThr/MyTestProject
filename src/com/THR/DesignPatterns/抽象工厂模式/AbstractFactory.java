package com.THR.DesignPatterns.���󹤳�ģʽ;

/**
 * ���󹤳���Զ����Ʒ�壬������Ե�����Ʒ��
 * ���߶�����ʱ��������ȥ�������󣬵����󹤳���������ض��Ĳ�Ʒ���󣬹�������������ȷ���Ĳ�Ʒ����
 */
public interface AbstractFactory {
    Cpu createCpu();
    Mainboard createMainboard();
}
