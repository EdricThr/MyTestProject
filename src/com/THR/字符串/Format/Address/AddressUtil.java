package com.THR.字符串.Format.Address;

import com.base.util.StringUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:
 *
 * @author : johnny
 *         date : 2017/7/17
 */
public class AddressUtil {
    /** 邮箱地址中的连接符@ */
    private static final String INTERNET_ADDRESS_LINK_SYMBOL = "@";
    /** InternetAddress对象邮箱地址的格式化默认前缀 */
    public static final String INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX = "<";
    /** InternetAddress对象邮箱地址的格式化默认后缀 */
    public static final String INTERNET_ADDRESS_DEFAULT_FORMAT_SUFFIX = ">";
    /** InternetAddress对象邮箱地址的界面或日志显示默认前缀 */
    public static final String INTERNET_ADDRESS_FORMAT_SHOW_PREFIX = "[";
    /** InternetAddress对象邮箱地址的界面或日志显示默认后缀 */
    public static final String INTERNET_ADDRESS_FORMAT_SHOW_SUFFIX = "]";
    /** More InternetAddress 格式化分隔符 */
    private static final String INTERNET_ADDRESS_MORE_FORMAT_SEPARATOR = ";";

    /** 错误的邮件地址 */
    private static final String MISSING_MAILBOX = "MISSING_MAILBOX@SYNTAX_ERROR";
    /** 预设可能存在的分隔符 */
    private static final char[] SPLITER_CHAR = new char[] {',', '，', '；', '：', '。', ':', '?', '？', '=', '+', '＝', '＋', '/', '\\', '、', '÷', '！', '!' };

    /** Message internet address,  eg: "johny" <test@test.com> 、johny <test@test.com> 、 <test@test.com>*/
    private static final Pattern INTERNET_ADDRESS_LONG_PATTERN = Pattern.compile("\"?(.*?)\"? *<(.*?)>");
    /** Internet address default format pattern, 第一参数：personal，第二参数：邮箱地址包含前缀符号
     *                                           第三参数：邮箱地址 ，第四参数：邮箱地址包含后缀符号
     *                                           eg: johnny <user1@test.com>、user1@test.com */
    private static final String INTERNET_ADDRESS_FORMAT_PATTERN = "%s %s%s%s";

    /**
     * 根据邮件地址得到该地址的小写域名
     * @param address
     * @return 域名
     */
    public static String getLowerCaseDomain(String address) {
        return getDomain(address).toLowerCase();
    }

    public static String getDomain(String address) {
        if(StringUtil.isEmpty(address)) {
            return StringUtil.EMPTY_STRING;
        }
        int index;
        if((index = address.trim().lastIndexOf(INTERNET_ADDRESS_LINK_SYMBOL)) >= 0) {
            return address.trim().substring(index+1);
        }
        return StringUtil.EMPTY_STRING;
    }


    /**
     * 解析邮件地址字符串为标准InternetAddress，
     * 邮件地址的格式中包含<>时，则<>中的内容为address属性，其余部分作为personal属性
     * 邮件地址的格式不包含<>时，则全部字符作为InternetAddress的address属性
     * @param internetAddressString 有格式的地址，eg："johny" <test@test.com> 、johny <test@test.com> 、 <test@test.com>、test@test.com
     * @return InternetAddress
     */
    public static InternetAddress parseInternetAddress(String internetAddressString) throws Exception {
        return parseInternetAddress(internetAddressString,false);
    }

    /**
     * 解析邮件地址字符串为标准InternetAddress，
     * 邮件地址的格式中包含<>时，则<>中的内容为address属性，其余部分作为personal属性
     * 邮件地址的格式不包含<>时，则全部字符作为InternetAddress的address属性
     * @param internetAddressString 有格式的地址，eg："johny" <test@test.com> 、johny <test@test.com> 、 <test@test.com>、test@test.com
     * @param isValidate 是否验证InternetAddress，false表示不验证，true表示验证
     * @return InternetAddress
     */
    public static InternetAddress parseInternetAddress(String internetAddressString,boolean isValidate) throws Exception {
        if(StringUtil.isEmpty(internetAddressString)) {
            return null;
        }
        InternetAddress internetAddress;
        Matcher m = INTERNET_ADDRESS_LONG_PATTERN.matcher(internetAddressString.trim());
        if (m.find()) {
            String personal = m.group(1);
            String address = m.group(2);
            if(StringUtil.isEmpty(address)) {
                return null;
            }
            internetAddress = new InternetAddress(address.trim(),personal);
        }
        else {
            internetAddress = new InternetAddress(internetAddressString.trim());
        }
        if(isValidate) {
            internetAddress.validate();
        }
        return internetAddress;
    }

    /**
     * 将以";"符号分隔的邮件地址字符串构造成InternetAddress的集合
     * @param interAddressStr 邮箱地址的字符串（多个是以;分隔的）
     * @return InternetAddress集合
     * @throws Exception
     */
    public final static List<InternetAddress> parseInternetAddressList(String interAddressStr) throws Exception {
        return parseInternetAddressList(interAddressStr, false);
    }

    /**
     * 将以";"符号分隔的邮件地址字符串构造成InternetAddress的集合
     * @param interAddressStr 邮箱地址的字符串（多个是以;分隔的）
     * @param isValidate  是否验证这个地址，false为不验证，true为验证
     * @modify 修正的处理：将整个地址信息放到InternetAddress的personal里，这样就不会报错了，适用于保存草稿时的处理
     * @return InternetAddress集合
     * @throws Exception
     */
    public final static List<InternetAddress> parseInternetAddressList(String interAddressStr, boolean isValidate) throws Exception {
        if(StringUtil.isEmpty(interAddressStr)) {
            return Collections.emptyList();
        }

        String[] internetAddressArray = interAddressStr.trim().split(INTERNET_ADDRESS_MORE_FORMAT_SEPARATOR);
        if(ArrayUtils.isEmpty(internetAddressArray)) {
            return Collections.emptyList();
        }

        List<InternetAddress> internetAddressList = new ArrayList<>();
        InternetAddress internetAddress;
        for(String internetAddressString : internetAddressArray) {
            if(StringUtil.isEmpty(internetAddressString)) {
                continue;
            }
            try {
                internetAddress = parseInternetAddress(internetAddressString.trim(),isValidate);
            }
            catch(Exception e) {
                String msg = internetAddressString.replace(INTERNET_ADDRESS_DEFAULT_FORMAT_SUFFIX, INTERNET_ADDRESS_FORMAT_SHOW_SUFFIX)
                        .replace(INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX, INTERNET_ADDRESS_FORMAT_SHOW_PREFIX) + "邮箱地址格式不正确";
                throw new Exception(msg,e);
            }
            if (null != internetAddress) {
                internetAddressList.add(internetAddress);
            }
        }
        return internetAddressList;

		/* 此处是以前的实现，先暂时保留
		List<InternetAddress> internetAddressList = new ArrayList<>();
		if(StringUtil.isEmpty(addressStr)) {
			return internetAddressList;
		}
		String[] addresses = uniformAddressSeparator(addressStr).split(String.valueOf(MAIL_ADDRESS_SEPARATOR));
		InternetAddress internetAddress = null;
		String tempStrs[] = null;
		String tempPersonal = null;
		for (String addresse : addresses) {
			if(StringUtil.isEmpty(addresse)) {
				continue;
			}
			tempPersonal = "";
			try {
				addresse = addresse.split(">")[0];
				tempStrs = addresse.split("<");
				if(tempStrs.length > 1) {
					tempPersonal = tempStrs[0].trim();
					// 如果存在用户名由双引号括起来的情况，则去除双引号
					addresse = addresse.replaceAll("\"", "").trim();
					addresse = tempStrs[1].trim();
				}
				internetAddress = new InternetAddress(addresse, tempPersonal);
				if(correctAddress) {
					internetAddress.validate();
				}
				internetAddressList.add(internetAddress);
			} catch (Exception e) {
				throw new Exception(addresse.replace(">", "]").replace("<", "[") + "无效邮箱地址");
			}
		}
		return internetAddressList;*/
    }

    /**
     * 将InternetAddress对象格式化为如：johny <user1@test.com>这样的格式化字符串,即格式化后的邮箱地址使用<>包含。
     * @param internetAddress InternetAddress地址对象
     * @return 格式化后的地址，eg：johny <user1@test.com> 、 user1@test.com ；
     *         若InternetAddress对象为null，则返回null
     */
    public static String defaultFormatInternetAddress(InternetAddress internetAddress) {
        return formatInternetAddress(internetAddress,INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX,INTERNET_ADDRESS_DEFAULT_FORMAT_SUFFIX);
    }

    /**
     * 将InternetAddress对象格式化为如：johny ${internetAddressFormatPrefix}user1@test.com${internetAddressFormatSuffix}这样的格式化字符串,即格式化后的邮箱地址使用<>包含。
     * @param internetAddress InternetAddress地址对象
     * @param internetAddressFormatPrefix 格式化邮箱地址的前缀包含符
     * @param internetAddressFormatSuffix 格式化邮箱地址的后缀包含符
     * @return 格式化后的地址，eg：johny ${internetAddressFormatPrefix}user1@test.com${internetAddressFormatSuffix} 、 user1@test.com ；
     *         若InternetAddress对象为null，则返回null
     * */
    public static String formatInternetAddress(InternetAddress internetAddress, String internetAddressFormatPrefix, String internetAddressFormatSuffix) {
        if(null == internetAddress|| StringUtil.isEmpty(internetAddress.getAddress())) {
            return null;
        }

        String personal = internetAddress.getPersonal();
        String address = internetAddress.getAddress();

        if(StringUtil.isEmpty(personal)) {
            return address.trim();
        }
        else {
            return String.format(INTERNET_ADDRESS_FORMAT_PATTERN,personal.trim(),internetAddressFormatPrefix,address.trim(),internetAddressFormatSuffix);
        }
        /*原始代码先留着，方便对照，后续运行一段时间后，删除
        address = address.replaceAll("\"", "").trim();
        if(StringUtil.isNotEmpty(personal)) {
            personal = personal.replaceAll("\"", "").trim();
            try {
                personal = MimeUtility.decodeText(personal);
            } catch (UnsupportedEncodingException e) {
            }
            if (address.equals(MISSING_MAILBOX)) {
                result = personal;
            } else {
                result = personal + addressPrefix + address + addressSuffix;
            }
        } else {
            result = address;
        }
        return result;*/
    }

    /**
     * 将邮箱地址对象转换为字符串,多个收件人之间用";"分割,收件人地址用"<"和">"括起来.
     * @param internetAddressCollection 地址集合
     * @return 格式化后的地址字符串，如：测试user1 <user1@test.com>; 测试user2 <user2@test.com>; user3@test.com
     */
    public final static String defaultFormatInternetAddress(Collection<InternetAddress> internetAddressCollection) {
        return formatInternetAddress(internetAddressCollection, INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX, INTERNET_ADDRESS_DEFAULT_FORMAT_SUFFIX);
    }

    /**
     * 将邮箱地址对象转换为字符串,多个收件人之间用";"分割,收件人地址用"${internetAddressFormatPrefix}"和"${internetAddressFormatSuffix}"括起来。
     * @param internetAddressCollection InternetAddress地址集合
     * @param internetAddressFormatPrefix 格式化邮箱地址的前缀包含符(地址与邮箱名称之间的分隔符)
     * @param internetAddressFormatSuffix 格式化邮箱地址的后缀包含符(地址的结尾分隔符)
     * @return 格式化后的地址字符串，如：测试user1 ${internetAddressFormatPrefix}user1@test.com${internetAddressFormatSuffix};user3@test.com
     * */
    public final static String formatInternetAddress(Collection<InternetAddress> internetAddressCollection,String internetAddressFormatPrefix, String internetAddressFormatSuffix) {
        if(CollectionUtils.isEmpty(internetAddressCollection)) {
            return null;
        }
        StringBuilder internetAddressFormatBuilder = new StringBuilder();
        String internetAddressFormatString;
        for (InternetAddress internetAddress : internetAddressCollection) {
            internetAddressFormatString = formatInternetAddress(internetAddress,internetAddressFormatPrefix,internetAddressFormatSuffix);
            if(StringUtil.isEmpty(internetAddressFormatString)) {
                continue;
            }
            internetAddressFormatBuilder.append(internetAddressFormatString).append(INTERNET_ADDRESS_MORE_FORMAT_SEPARATOR);
        }
        if(internetAddressFormatBuilder.length() > 0) {
            internetAddressFormatBuilder.deleteCharAt(internetAddressFormatBuilder.length() - 1);
        }
        return internetAddressFormatBuilder.toString();
    }

    /**
     * 格式化邮箱地址，多个收件人之间用";"分割,收件人地址用"<"和">"括起来，即使只有一个收件人地址，也会用"<"和">"括起来
     * @param addressStr 使用";"分隔的地址字符串
     * @return 返回标准的经过格式化的InternetAddress字符串，eg: johnny<user1@test.com>;<user2@test.com>
     */
    public static String formatInternetAddressString(String addressStr) throws Exception {
        if(StringUtil.isEmpty(addressStr)) {
            return StringUtil.EMPTY_STRING;
        }
        String[] internetAddressArray = addressStr.trim().split(INTERNET_ADDRESS_MORE_FORMAT_SEPARATOR);
        if(ArrayUtils.isEmpty(internetAddressArray)) {
            return StringUtil.EMPTY_STRING;
        }
        StringBuilder standardizationBuilder = new StringBuilder();
        Matcher matcher;
        String personal = null;
        String address;
        for(String internetAddressString : internetAddressArray) {
            if(StringUtil.isEmpty(internetAddressString)) {
                continue;
            }
            try {
                matcher = INTERNET_ADDRESS_LONG_PATTERN.matcher(internetAddressString.trim());
                if (matcher.find()) {
                    personal = matcher.group(1);
                    address = matcher.group(2);
                }
                else {
                    address = internetAddressString.trim();
                }
                if(StringUtil.isEmpty(address)) {
                    continue;
                }
                personal = StringUtil.defaultIfEmpty(personal,StringUtil.EMPTY_STRING);
                standardizationBuilder.append(personal)
                        .append(INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX)
                        .append(address.trim())
                        .append(INTERNET_ADDRESS_DEFAULT_FORMAT_SUFFIX)
                        .append(INTERNET_ADDRESS_MORE_FORMAT_SEPARATOR);
            }
            catch (Exception e) {
                String msg = internetAddressString.replace(INTERNET_ADDRESS_DEFAULT_FORMAT_SUFFIX, INTERNET_ADDRESS_FORMAT_SHOW_SUFFIX)
                        .replace(INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX, INTERNET_ADDRESS_FORMAT_SHOW_PREFIX) + "邮箱地址格式不正确";
                throw new Exception(msg,e);
            }
        }
        if(standardizationBuilder.length() > 0) {
            standardizationBuilder.deleteCharAt(standardizationBuilder.length() - 1);
        }
        return standardizationBuilder.toString();

        /*原始代码先留着，方便对照，后续运行一段时间后，删除
        StringBuilder addressBuilder = new StringBuilder();
        if(StringUtil.isNotEmpty(addressStr)) {
            String[] addresses = uniformAddressSeparator(addressStr).split(String.valueOf(MAIL_ADDRESS_SEPARATOR));
            String tempStrs[] = null;
            String tempPersonal = null;
            for (String addresse : addresses) {
                if(StringUtil.isEmpty(addresse)) {
                    continue;
                }
                tempPersonal = "";
                try {
                    addresse = addresse.split(">")[0];
                    tempStrs = addresse.split("<");
                    if(tempStrs.length > 1) {
                        tempPersonal = tempStrs[0].trim();
                        addresse = tempStrs[1].trim();
                    }
                    addressBuilder.append(tempPersonal).append(MAIL_ADDRESS_PREFIX).append(addresse).append(MAIL_ADDRESS_SUFFIX).append(MAIL_ADDRESS_SEPARATOR);
                } catch (Exception e) {
                    throw new Exception(addresse.replace(">", "]").replace("<", "[") + "无效邮箱地址");
                }
            }
            if(addressBuilder.toString().endsWith(";")) {
                addressBuilder.deleteCharAt(addressBuilder.length() - 1);
            }
        }
        return addressBuilder.toString();
         */
    }

    /**
     * 从以";"分隔的字符串中的抽取出邮件地址，以集合的形式返回。
     * eg: 字符串为：测试user1<user1@test.com>;user2@test.com;<user3@test.com>
     *     得到的结果是 user1@test.com、user2@test.com、user3@test.com为元素的集合
     * @param addressStr 使用";"分隔的地址字符串
     * @return 邮箱地址的集合
     */
    public static List<String> extractAddressList(String addressStr) throws Exception {
        if(StringUtil.isEmpty(addressStr)) {
            return Collections.emptyList();
        }
        String[] internetAddressArray = addressStr.trim().split(INTERNET_ADDRESS_MORE_FORMAT_SEPARATOR);
        if(ArrayUtils.isEmpty(internetAddressArray)) {
            return Collections.emptyList();
        }
        List<String> addressList = new ArrayList<>(internetAddressArray.length);
        Matcher matcher;
        String address;
        for(String internetAddressString : internetAddressArray) {
            if(StringUtil.isEmpty(internetAddressString)) {
                continue;
            }
            matcher = INTERNET_ADDRESS_LONG_PATTERN.matcher(internetAddressString.trim());
            if (matcher.find()) {
                address = matcher.group(2);
            }
            else {
                address = internetAddressString.trim();
            }
            if(StringUtil.isEmpty(address)) {
                continue;
            }
            addressList.add(address.trim());
        }
        return addressList;
    }

    /**
     * 统一邮件地址分隔符
     * @param mailAddress 邮件地址，可能有多个
     * @return
     */
    /*private final static String uniformAddressSeparator(String mailAddress) {
        if(StringUtil.isNotEmpty(mailAddress)) {
            mailAddress = mailAddress.replaceAll("\"", "").replaceAll("'", "");
            for (int i = 0, length = SPLITER_CHAR.length; i < length; i++) {
                mailAddress = mailAddress.replace(SPLITER_CHAR[i],INTERNET_ADDRESS_MORE_FORMAT_SEPARATOR);
            }
        }
        return mailAddress;
    }*/
}
