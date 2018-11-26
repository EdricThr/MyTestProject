/**
 * File: StringUtil.java
 *
 * @author yzf
 * @version 1.1.0 2010-10-14
 *
 * Copyright (C) 2006,2007 , KOAL, Inc.
 */
package com.base.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class StringUtil
{
    public static final String EMPTY_STRING = "";
    private static final String RANDOM_BASE_STRING = "abcdefg98765hijklmn421!@$#%30uvwxyzopqrst";

    //ƴ�������ʽ
    private static HanyuPinyinOutputFormat pinyinFormat = new HanyuPinyinOutputFormat();

    /*
     * ��html�е�<��>�ĳ�ת���ַ�
     */
    public static String escapeHtml(String str)
    {
        str = str.replace("<", "&lt;").replace(">", "&gt;");
        return str;
    }
    
    /*
     * ���ַ������һ��������ʾ��Ϣ��HTML��ﴮ
     */
    public static String attachHtmlTitle(String str)
    {
        return "<span title=\"" + str + "\">" + str + "</span>";
    }
    
    /**
     * ���ַ������һ��������ʾ��Ϣ��HTML��ﴮ
     * @param str    ��ʾ��������Ϣ
     * @param promptInfo ��ʾ��Ϣ
     * @return
     */
    public static String attachHtmlTitle(String str,String promptInfo)
    {
        return "<span title=\"" + promptInfo + "\">" + str + "</span>";
    }
    
    /**
     * ȥ���ַ����Ļس����з�
     * @param str
     * @return
     */
    public static String clearRN(String str)
    {
        str = str.replaceAll("\r\n", "");
        str = str.replaceAll("\n", "");
        
        return str;
    }
    
    /**
     * ���س����з�����<br>
     * @param str
     * @return
     */
    public static String convertRNToBR(String str)
    {
        str = str.replaceAll("\r\n", "<br>");
        str = str.replaceAll("\n", "<br>");
        
        return str;
    }

    /**
     * ���������
     * @param sLen
     * @return String
     */
    public static String getRandomString(int sLen) {
        int baseStrLength = RANDOM_BASE_STRING.length();
        StringBuilder randomBuilder = new StringBuilder(sLen);
        for(int i = 0; i < sLen; i++) {
            int p = (int)(Math.random()*(baseStrLength+1));
            if (p >= baseStrLength) {
                p = baseStrLength -1;
            }
            randomBuilder.append(RANDOM_BASE_STRING.substring(p, p + 1));
        }
        return randomBuilder.toString();
    }

    public static String converterToPinYin(String chinese){
        String pinyinString = "";
        char[] charArray = chinese.toCharArray();
        //����Ҫ����
        pinyinFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        try {
            //�������飬ASC�����128����ת��
            for (int i = 0; i <charArray.length; i++) {  
                if (charArray[i] > 128) {
                    //charAt(0)ȡ������ĸ
                    pinyinString += PinyinHelper.toHanyuPinyinStringArray(charArray[i], pinyinFormat)[0];
                }else{
                    pinyinString += charArray[i];
                }
            }
            
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            pinyinString = "";
        }
        
        return pinyinString;
    }
    
    public static String convertDateToStr(Date date)
    {
        return convertDateToStr(date, "yyyy-MM-dd HH:mm:ss");
    }
    
    public static String convertDateToStr(Date date, String pattern)
    {
    	SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern(pattern);
        return dateFormat.format(date);
    }
    
    //�ж��ַ����Ƿ����email��ʽ
    public static boolean isEmail(String emailStr)
    {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]\\w*([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
//    	Pattern p = Pattern.compile("^[a-zA-Z\\d][a-zA-Z\\d-_]*@([a-zA-Z\\d]([a-zA-Z\\d\\-]{0,61}[a-zA-Z\\d])?\\.)+[a-zA-Z]{2,6}$");
        return p.matcher(emailStr.toString().trim()).matches();
    }

    //�ж��ַ����Ƿ����������ʽ
    public static boolean isDomain(String domainStr)
    {
        Pattern p = Pattern.compile("^\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        return p.matcher(domainStr.toString().trim()).matches();
    }

    //�ж��ַ����Ƿ����������ʽ
    public static boolean isIP(String ipStr)
    {
        Pattern p = Pattern.compile("^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])(\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])){3}$");
        return p.matcher(ipStr.toString().trim()).matches();
    }

    public static String getChinaWeekStrByDate(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        //dayOfWeek=1��ʾ������  dayOfWeek=7��ʾ������
        String weekStr = "δ֪";
        if (dayOfWeek == 1)
        {
            weekStr = "������";
        }
        else if (dayOfWeek > 1 && dayOfWeek <= 7)
        {
            String[] chinaDaysOfWeek = new String[]{"һ", "��", "��", "��", "��", "��"}; 
            weekStr = "����" + chinaDaysOfWeek[dayOfWeek - 2];
        }
        
        return weekStr;
    }
    
    public static Integer[] convertStrsToInts(String[] strs)
    {
        Integer[] ints = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++)
        {
            ints[i] = Integer.valueOf(strs[i]);
        }
        return ints;
    }
    
    public static Integer[] ConvertMapListToIdArray( List<Map<Object, Object>> mapList, String key)
    {
        List<Integer> valueList = new ArrayList<Integer>();
        if (mapList != null)
        {
            for(Map<Object, Object> map : mapList)
            {
                valueList.add((Integer)map.get(key));
            }
        }
        
        return valueList.toArray(new Integer[]{});
    }
    
    public static long[] convertStrsTolongs(String[] strs)
    {
        long[] longs = new long[strs.length];
        for (int i = 0; i < strs.length; i++)
        {
            longs[i] = Long.valueOf(strs[i]).longValue();
        }
        return longs;
    }
    

    /**
     * ���ַ�����ͨ���ָ���ƴ�ӳ�һ���ַ���
     * @param str �ַ�������
     * @param split �ָ�������",";
     * @param endIsSplit �Ƿ���Ҫ�ָ�����β
     * @param singleQuotes �Ƿ�Ҫ�ӵ�����"'";
     * @return
     */
    public static String jointListToString(List<String> str,String split,boolean endIsSplit,boolean singleQuotes){
    	StringBuffer strBuild=new StringBuffer();
    	if(str!=null && str.size()>0){
    		for(int i=0;i<str.size();i++){
    			if(singleQuotes){
    				if(i==0){
    					strBuild.append("'");
    					strBuild.append(str.get(i));
    					strBuild.append("'");
    				}else{
    					strBuild.append(split);
    					strBuild.append("'");
    					strBuild.append(str.get(i));
    					strBuild.append("'");
    				}
    			}else{
    				if(i==0){
    					strBuild.append(str.get(i));
    				}else{
    					strBuild.append(split);
    					strBuild.append(str.get(i));
    				}
    			}
    		}
			if(endIsSplit){
				strBuild.append(split);
			}
    	}
    	return strBuild.toString();
    }
    /**
	 * ��ȡ�ַ������ָ���֮ǰ������
	 * @param str
	 * @param split
	 * @return
	 * @throws Exception
	 */
	public static String mvStringLastSplit(String str,String split) throws Exception {
		String beUsedString =str;
		String s1 = beUsedString.substring(0, beUsedString.lastIndexOf(split));
		beUsedString = s1 ;
		return beUsedString;
	}
	
	/**
	 * ���Ϊ���򷵻�true������Ϊfalse
     * common-lang3-stringUtils�е�emptyδ���ַ���trim,���������Ƿֿ���,����ϲ�
     * @see StringUtils#trim(String)
     * @see StringUtils#isEmpty(CharSequence)
	 * @param itemValue
	 * @return
	 */
	public static boolean isEmpty(String itemValue) {
		return StringUtils.isEmpty(StringUtils.trim(itemValue));
	}
	
	/**
	 * �����Ϊ���򷵻�true�����򷵻�false
	 * @param itemValue
	 * @return
	 */
	public static boolean isNotEmpty(String itemValue) {
		return !isEmpty(itemValue);
	}

    /**
     * �Ƿ�����Ԫ�ؾ�Ϊ�ǿ�
     * @param values
     * @return true:���Ƿǿ� false:�зǿյ�
     */
	public static boolean isAllNotEmpty(String... values) {
        if(values == null) return false;
        for(String value : values) {
            if(isEmpty(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * ������һ��Ϊ�ǿ�Ԫ��
     * @param values
     * @return true���������κ�һ��Ϊ�ǿգ� false��û�зǿյ�
     */
    public static boolean isAnyNotEmpty(String... values) {
        if(values == null) return false;
        for(String value : values) {
            if(isNotEmpty(value)) {
                return true;
            }
        }
        return false;
    }

	/**
	 * �ж�һ���ַ����Ƿ���ڸ����ĳ��ȣ�������ڸ����ĳ����򷵻�true�����򷵻�false
	 * @param itemValue ��Ҫ�����ַ���
	 * @param size �綨�ĳ���
	 * @return
	 */
	public static boolean checkLength(String itemValue,int size) {
		if(isEmpty(itemValue)) {
			return false;
		}
		return itemValue.length() > size ? true : false;
	}
	
	public static boolean isNumber(String itemValue){
		return NumberUtils.isNumber(StringUtils.trim(itemValue));
	}
	
	public static String getValue(String msg,String defaultValue) {
		if(isEmpty(msg)) {
			return defaultValue;
		}
		return msg;
	}
	
	/**
	 * ȥ���ַ����е����пո񣬰������ַ����еĿո�
	 * @param str
	 * @return
	 */
	public static String trimAllBlank(String str) {
		if(isEmpty(str)) {
			return "";
		}
		return str.replaceAll(" ","");
	}
	
    /*public static void printBytes(String desc, byte[] b)
    {
        printBytes(desc, b, 20, " ");
    }

    public static void printBytes(String desc, byte[] b, int lineLen, String separator)
    {
        System.out.println(desc + "------");
        int j = 0;
        for (int i = 0; i < b.length; i++)
        {
            j++;
            String str = "00" + Integer.toHexString(b[i]);
            if (str.length() > 2)
            {
                str = str.substring(str.length() - 2);
            }
            System.out.print(str + separator);
            if (j == lineLen)
            {
                System.out.println("");
                j = 0;
            }

        }
        System.out.println("");
    }*/
    
	/**
	 * �ж����Ƿ���ע�ͣ������ַ�����"#��ͷ��Ϊע��"
	 * @param str
	 * @return
	 */
	public static boolean isCommentary(String str,String commentFlag) {
		return str.matches("^\\s*"+commentFlag+".*");
	}
	
	public static long ip2Long(String ip) {
	    String[] items = ip.split("\\.");
	    return Long.valueOf(items[0]) << 24
	            | Long.valueOf(items[1]) << 16
	            | Long.valueOf(items[2]) << 8 | Long.valueOf(items[3]);
	}
	
	public static String long2Ip(long ipNum) {
		StringBuilder sb = new StringBuilder("");
		sb.append(String.valueOf((ipNum >>> 24)));
		sb.append(".");
		sb.append(String.valueOf((ipNum & 0x00FFFFFF) >>> 16));
		sb.append(".");
		sb.append(String.valueOf((ipNum & 0x0000FFFF) >>> 8));
		sb.append(".");
		sb.append(String.valueOf((ipNum & 0x000000FF)));
		return sb.toString();
	}
	
	public static String newString(String str, String origCharSetName, String newCharSetName) throws Exception {
		return new String(str.getBytes(origCharSetName), newCharSetName);
	}

	public static void requireNonEmpty(String str) throws Exception {
        if(isEmpty(str)) {
            throw new IllegalArgumentException("�ַ�����Ϊ�գ�");
        }
    }

    public static void requireNonEmpty(String str, String message) throws Exception {
        if(isEmpty(str)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static boolean equalOr(String srcString, String ... compStrs) {
        if(null == srcString) return false;
        if(null == compStrs) return false;

        for(String compStr : compStrs) {
            if(srcString.equals(compStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * ���Ϊ�գ���ʹ��Ĭ��ֵ���˴�NULL��" "�������������ΪEMPTY����ͬ��org.apache.commons.lang3.StringUtils#defaultIfEmpty
     * @param str
     * @param defaultStr
     * @return
     */
    public static String defaultIfEmpty(String str, String defaultStr) {
        return isEmpty(str) ? defaultStr : str.trim();
    }
	
    public static void main(String[] args) throws Exception
    {
    	System.out.println(getRandomString(16));
    }
}

