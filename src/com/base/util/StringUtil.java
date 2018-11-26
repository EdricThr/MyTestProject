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

    //拼音输出格式
    private static HanyuPinyinOutputFormat pinyinFormat = new HanyuPinyinOutputFormat();

    /*
     * 将html中的<和>改成转义字符
     */
    public static String escapeHtml(String str)
    {
        str = str.replace("<", "&lt;").replace(">", "&gt;");
        return str;
    }
    
    /*
     * 将字符串变成一串带有提示信息的HTML表达串
     */
    public static String attachHtmlTitle(String str)
    {
        return "<span title=\"" + str + "\">" + str + "</span>";
    }
    
    /**
     * 将字符串变成一串带有提示信息的HTML表达串
     * @param str    显示出来的信息
     * @param promptInfo 提示信息
     * @return
     */
    public static String attachHtmlTitle(String str,String promptInfo)
    {
        return "<span title=\"" + promptInfo + "\">" + str + "</span>";
    }
    
    /**
     * 去掉字符串的回车换行符
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
     * 将回车换行符换成<br>
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
     * 生成随机数
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
        //不需要音调
        pinyinFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        try {
            //遍历数组，ASC码大于128进行转换
            for (int i = 0; i <charArray.length; i++) {  
                if (charArray[i] > 128) {
                    //charAt(0)取出首字母
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

    public static String getChinaWeekStrByDate(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        //dayOfWeek=1表示星期日  dayOfWeek=7表示星期六
        String weekStr = "未知";
        if (dayOfWeek == 1)
        {
            weekStr = "星期日";
        }
        else if (dayOfWeek > 1 && dayOfWeek <= 7)
        {
            String[] chinaDaysOfWeek = new String[]{"一", "二", "三", "四", "五", "六"}; 
            weekStr = "星期" + chinaDaysOfWeek[dayOfWeek - 2];
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
     * 将字符串组通过分隔符拼接成一个字符串
     * @param str 字符串队列
     * @param split 分隔符，如",";
     * @param endIsSplit 是否需要分隔符结尾
     * @param singleQuotes 是否要加单引号"'";
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
	 * 截取字符串最后分隔符之前的内容
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
	 * 如果为空则返回true，否则为false
     * common-lang3-stringUtils中的empty未对字符串trim,两个方法是分开的,这里合并
     * @see StringUtils#trim(String)
     * @see StringUtils#isEmpty(CharSequence)
	 * @param itemValue
	 * @return
	 */
	public static boolean isEmpty(String itemValue) {
		return StringUtils.isEmpty(StringUtils.trim(itemValue));
	}
	
	/**
	 * 如果不为空则返回true，否则返回false
	 * @param itemValue
	 * @return
	 */
	public static boolean isNotEmpty(String itemValue) {
		return !isEmpty(itemValue);
	}

    /**
     * 是否所有元素均为非空
     * @param values
     * @return true:都是非空 false:有非空的
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
     * 有任意一个为非空元素
     * @param values
     * @return true：其中有任何一个为非空， false：没有非空的
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
	 * 判断一个字符串是否大于给定的长度，如果大于给定的长度则返回true，否则返回false
	 * @param itemValue 需要检测的字符串
	 * @param size 界定的长度
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
	 * 去除字符串中的所有空格，包括在字符串中的空格
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
	 * 判断行是否是注释，例如字符是以"#开头视为注释"
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
            throw new IllegalArgumentException("字符不能为空！");
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
     * 如果为空，则使用默认值。此处NULL和" "这两种情况均视为EMPTY，不同于org.apache.commons.lang3.StringUtils#defaultIfEmpty
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

