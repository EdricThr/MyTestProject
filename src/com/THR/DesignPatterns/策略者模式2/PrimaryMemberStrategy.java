package com.THR.DesignPatterns.������ģʽ2;

public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double price) {
        System.out.println("������Ա9���Żݣ�");
        return 0.9 * price;
    }
}
