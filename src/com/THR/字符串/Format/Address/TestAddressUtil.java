package com.THR.×Ö·û´®.Format.Address;

import javax.mail.internet.InternetAddress;
import java.util.List;

public class TestAddressUtil {

    public static void main(String args[]) throws Exception {
        String str = "user1<useruser1@thr.com>;user1<user1@thr.com>;user2<user2@thr.com>;user4<user4@thr.com>;772434704@qq.com<772434704@qq.com>";
        List<InternetAddress> list = AddressUtil.parseInternetAddressList(str);
        for (InternetAddress address : list) {
            System.out.println(address.getAddress());
        }
        System.out.println("--------------------------");
        String str2 = "user1<useruser1@thr.com>";
        List<InternetAddress> list2 = AddressUtil.parseInternetAddressList(str2);
        for (InternetAddress address : list2) {
            System.out.println(address.getAddress());
        }
    }
}
