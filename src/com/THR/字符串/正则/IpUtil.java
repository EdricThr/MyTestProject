package com.THR.�ַ���.����;


import com.base.util.StringUtil;

public class IpUtil {
    
    /**
     * �Ƚ�formerIP�Ƿ����latterIP
     * @param formerIP ǰIP
     * @param latterIP ��IP
     * @return true:����;false:С��
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
     * �Ƚ�ip�Ƿ���[startIP, endIP]������
     * @param ip Ŀ��ip
     * @param startIP ip����ǰֵ
     * @param endIP ip�����ֵ
     * @return true:��;false:����
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
     * ��ʽ��ip��ʹ��ip����ת��Ϊ3λ(����3λǰ�油0)
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
