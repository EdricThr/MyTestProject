package com.THR.DesignPatterns.策略者模式2;

public class Client_CeLue2 {

    public static void main(String args[]){
        MemberStrategy strategy = new PrimaryMemberStrategy();
        //策略模式的环境不决定什么时候使用什么算法，是由客户端决定的
        Price price = new Price(strategy);
        System.out.println("最终价格：" + price.quote(99.8));
    }
}
