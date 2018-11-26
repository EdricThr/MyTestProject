package com.THR.DesignPatterns.策略者模式2;

public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double price) {
        System.out.println("初级会员9折优惠：");
        return 0.9 * price;
    }
}
