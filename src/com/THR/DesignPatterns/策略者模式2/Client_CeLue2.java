package com.THR.DesignPatterns.������ģʽ2;

public class Client_CeLue2 {

    public static void main(String args[]){
        MemberStrategy strategy = new PrimaryMemberStrategy();
        //����ģʽ�Ļ���������ʲôʱ��ʹ��ʲô�㷨�����ɿͻ��˾�����
        Price price = new Price(strategy);
        System.out.println("���ռ۸�" + price.quote(99.8));
    }
}
