package com.THR.字符串.正则;


import com.base.util.StringUtil;

public class IpUtil {
    
    /**
     * 比较formerIP是否大于latterIP
     * @param formerIP 前IP
     * @param latterIP 后IP
     * @return true:大于;false:小于
     */
    public static boolean isIpBigger(String formerIP, String latterIP) {
        if (!StringUtil.isAllNotEmpty(formerIP, latterIP)){
            return false;
        }
        if (ipFormat(formerIP).compareTo(ipFormat(latterIP)) >= 0) {
            return true;
        }
        return false;
    }
    /**
     * 比较ip是否在[startIP, endIP]区间内
     * @param ip 目标ip
     * @param startIP ip区间前值
     * @param endIP ip区间后值
     * @return true:在;false:不在
     */
    public static boolean isIpBetween(String ip, String startIP, String endIP) {
        if (!StringUtil.isAllNotEmpty(startIP, endIP, ip)){
            return false;
        }
        if (ipFormat(ip).compareTo(ipFormat(startIP)) >= 0 && ipFormat(ip).compareTo(ipFormat(endIP)) <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 格式化ip，使得ip各段转换为3位(少于3位前面补0)
     * @param ip
     * @return
     */
    private static String ipFormat(String ip){
        return ip.replaceAll("(\\d+)", "00$1").replaceAll("0*(\\d{3})", "$1");
    }


    public static long ip2Long(String ip) {
        String[] items = ip.split("\\.");
        return Long.valueOf(items[0]) << 24
                | Long.valueOf(items[1]) << 16
                | Long.valueOf(items[2]) << 8 | Long.valueOf(items[3]);
    }

    public static String long2Ip(long ipNum) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf((ipNum >>> 24)));
        sb.append(".");
        sb.append(String.valueOf((ipNum & 0x00FFFFFF) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((ipNum & 0x0000FFFF) >>> 8));
        sb.append(".");
        sb.append(String.valueOf((ipNum & 0x000000FF)));
        return sb.toString();
    }
}
