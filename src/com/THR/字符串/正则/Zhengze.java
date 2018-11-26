package com.THR.�ַ���.����;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zhengze {

    public static void main(String args[]) throws Exception {

        //doTestD("1");
    }

    private static void doTestD(String compareStr, Pattern pattern){
        String dPattten = "^\\d$";
        pattern = Pattern.compile(dPattten);
        Matcher matcher = pattern.matcher(compareStr);
        System.out.println(matcher.matches());
    }

    /**
     * �ж��Ƿ����IP��ַ�ĸ�ʽ
     *
     * @param accessIP
     * @return
     */
    public boolean isSingleIp(String accessIP) {

        //���� ��������
        String ipPattern2 = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        /*
        ��һ��IP��ƥ�䷽ʽ�������00.01���֣�������
        * function isIp(ipAddressString)
            {
               var reSpaceCheck = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])(\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])){3}$/;
               var passedTest = false;
               if (reSpaceCheck.test(ipAddressString))
               {
                  ipAddressString.match(reSpaceCheck);
                  if (RegExp.$1 <= 255 && RegExp.$1 >= 0 && RegExp.$2 <= 255 && RegExp.$2 >= 0 && RegExp.$3 <= 255 && RegExp.$3 >= 0 && RegExp.$4 <= 255 && RegExp.$4 >= 0)
                  {
                     passedTest = true;
                  }
               }
               return passedTest;
            }
        *
        *
        *
        * */

        String ipPattern = "^([1-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])){3}$";
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(accessIP);
        return matcher.matches();
    }

    /**
     * �ж��Ƿ��������IP�м���һ����-��
     *
     * @param accessIP
     * @return
     */
    public boolean isPairIp(String accessIP) {
        boolean isPairIpPassed = false;
        String ipPattern = "^([1-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])){3}-([1-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])){3}$";
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(accessIP);
        if (matcher.matches()) {
            String pairIpArray[] = accessIP.split("-");
            if (null != pairIpArray && pairIpArray.length > 0) {
                if (IpUtil.isIpBigger(pairIpArray[1], pairIpArray[0])) {
                    isPairIpPassed = true;
                }
            }
        } else {
            isPairIpPassed = false;
        }
        return isPairIpPassed;
    }

    /**
     * �ж��Ƿ����IP���һλΪͨ���*
     *
     * @param accessIP
     * @return
     */
    public boolean isStarIp(String accessIP) {
        String ipPattern = "^([1-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])){2}\\.\\*$";
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(accessIP);
        return matcher.matches();
    }

    public static void test() {
        String ip = "([1-9]|[1-9]//d|1//d{2}|2[0-4]//d|25[0-5])(//.(//d|[1-9]//d|1//d{2}|2[0-4]//d|25[0-5])){3}";

        String str = "^(192)\\.(168)\\.(42)\\.(120)$";
    }

    private static void doOneIp(){
        String str = "^(192)\\.(168)\\.(42)\\.(120)$";
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher("192.168.42.120");
        System.out.println(matcher.matches());

        System.out.println("-----------");
        parseStr(str);
    }

    public static void parseStr(String str) {
        String ss[] = str.split("\\W+");
        System.out.println(ss.length);
        for (int i = 0; i < ss.length; i++) {
            System.out.println("--" + ss[i]);
        }
    }
}