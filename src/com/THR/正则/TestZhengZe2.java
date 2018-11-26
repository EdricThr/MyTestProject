package com.THR.正则;

import java.util.regex.Pattern;

public class TestZhengZe2 {

    public static void main(String args[]){
        //System.out.println(true?"true":"false");
        //test(null);
        //Integer.valueOf("");
        System.out.println(isDomain("a-aa.bbb.com"));
        System.out.println(isIP("255.192.168.2"));
    }




    public static void test(Object obj){
        if (null == obj){
            System.out.println("--------------");
        }
    }

    //判断字符串是否符合email格式
    public static boolean isEmail(String emailStr)
    {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]\\w*([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
//    	Pattern p = Pattern.compile("^[a-zA-Z\\d][a-zA-Z\\d-_]*@([a-zA-Z\\d]([a-zA-Z\\d\\-]{0,61}[a-zA-Z\\d])?\\.)+[a-zA-Z]{2,6}$");
        return p.matcher(emailStr.toString().trim()).matches();
    }
    //判断字符串是否符合域名格式
    public static boolean isDomain(String domainStr)
    {
        Pattern p = Pattern.compile("^\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        return p.matcher(domainStr.toString().trim()).matches();
    }
    //判断字符串是否符合域名格式
    public static boolean isIP(String ipStr)
    {
        Pattern p = Pattern.compile("^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])(\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])){3}$");
        return p.matcher(ipStr.toString().trim()).matches();
    }
}
