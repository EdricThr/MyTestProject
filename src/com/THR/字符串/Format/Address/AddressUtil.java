package com.THR.�ַ���.Format.Address;

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
    /** �����ַ�е����ӷ�@ */
    private static final String INTERNET_ADDRESS_LINK_SYMBOL = "@";
    /** InternetAddress���������ַ�ĸ�ʽ��Ĭ��ǰ׺ */
    public static final String INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX = "<";
    /** InternetAddress���������ַ�ĸ�ʽ��Ĭ�Ϻ�׺ */
    public static final String INTERNET_ADDRESS_DEFAULT_FORMAT_SUFFIX = ">";
    /** InternetAddress���������ַ�Ľ������־��ʾĬ��ǰ׺ */
    public static final String INTERNET_ADDRESS_FORMAT_SHOW_PREFIX = "[";
    /** InternetAddress���������ַ�Ľ������־��ʾĬ�Ϻ�׺ */
    public static final String INTERNET_ADDRESS_FORMAT_SHOW_SUFFIX = "]";
    /** More InternetAddress ��ʽ���ָ��� */
    private static final String INTERNET_ADDRESS_MORE_FORMAT_SEPARATOR = ";";

    /** ������ʼ���ַ */
    private static final String MISSING_MAILBOX = "MISSING_MAILBOX@SYNTAX_ERROR";
    /** Ԥ����ܴ��ڵķָ��� */
    private static final char[] SPLITER_CHAR = new char[] {',', '��', '��', '��', '��', ':', '?', '��', '=', '+', '��', '��', '/', '\\', '��', '��', '��', '!' };

    /** Message internet address,  eg: "johny" <test@test.com> ��johny <test@test.com> �� <test@test.com>*/
    private static final Pattern INTERNET_ADDRESS_LONG_PATTERN = Pattern.compile("\"?(.*?)\"? *<(.*?)>");
    /** Internet address default format pattern, ��һ������personal���ڶ������������ַ����ǰ׺����
     *                                           ���������������ַ �����Ĳ����������ַ������׺����
     *                                           eg: johnny <user1@test.com>��user1@test.com */
    private static final String INTERNET_ADDRESS_FORMAT_PATTERN = "%s %s%s%s";

    /**
     * �����ʼ���ַ�õ��õ�ַ��Сд����
     * @param address
     * @return ����
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
     * �����ʼ���ַ�ַ���Ϊ��׼InternetAddress��
     * �ʼ���ַ�ĸ�ʽ�а���<>ʱ����<>�е�����Ϊaddress���ԣ����ಿ����Ϊpersonal����
     * �ʼ���ַ�ĸ�ʽ������<>ʱ����ȫ���ַ���ΪInternetAddress��address����
     * @param internetAddressString �и�ʽ�ĵ�ַ��eg��"johny" <test@test.com> ��johny <test@test.com> �� <test@test.com>��test@test.com
     * @return InternetAddress
     */
    public static InternetAddress parseInternetAddress(String internetAddressString) throws Exception {
        return parseInternetAddress(internetAddressString,false);
    }

    /**
     * �����ʼ���ַ�ַ���Ϊ��׼InternetAddress��
     * �ʼ���ַ�ĸ�ʽ�а���<>ʱ����<>�е�����Ϊaddress���ԣ����ಿ����Ϊpersonal����
     * �ʼ���ַ�ĸ�ʽ������<>ʱ����ȫ���ַ���ΪInternetAddress��address����
     * @param internetAddressString �и�ʽ�ĵ�ַ��eg��"johny" <test@test.com> ��johny <test@test.com> �� <test@test.com>��test@test.com
     * @param isValidate �Ƿ���֤InternetAddress��false��ʾ����֤��true��ʾ��֤
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
     * ����";"���ŷָ����ʼ���ַ�ַ��������InternetAddress�ļ���
     * @param interAddressStr �����ַ���ַ������������;�ָ��ģ�
     * @return InternetAddress����
     * @throws Exception
     */
    public final static List<InternetAddress> parseInternetAddressList(String interAddressStr) throws Exception {
        return parseInternetAddressList(interAddressStr, false);
    }

    /**
     * ����";"���ŷָ����ʼ���ַ�ַ��������InternetAddress�ļ���
     * @param interAddressStr �����ַ���ַ������������;�ָ��ģ�
     * @param isValidate  �Ƿ���֤�����ַ��falseΪ����֤��trueΪ��֤
     * @modify �����Ĵ�����������ַ��Ϣ�ŵ�InternetAddress��personal������Ͳ��ᱨ���ˣ������ڱ���ݸ�ʱ�Ĵ���
     * @return InternetAddress����
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
                        .replace(INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX, INTERNET_ADDRESS_FORMAT_SHOW_PREFIX) + "�����ַ��ʽ����ȷ";
                throw new Exception(msg,e);
            }
            if (null != internetAddress) {
                internetAddressList.add(internetAddress);
            }
        }
        return internetAddressList;

		/* �˴�����ǰ��ʵ�֣�����ʱ����
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
					// ��������û�����˫�������������������ȥ��˫����
					addresse = addresse.replaceAll("\"", "").trim();
					addresse = tempStrs[1].trim();
				}
				internetAddress = new InternetAddress(addresse, tempPersonal);
				if(correctAddress) {
					internetAddress.validate();
				}
				internetAddressList.add(internetAddress);
			} catch (Exception e) {
				throw new Exception(addresse.replace(">", "]").replace("<", "[") + "��Ч�����ַ");
			}
		}
		return internetAddressList;*/
    }

    /**
     * ��InternetAddress�����ʽ��Ϊ�磺johny <user1@test.com>�����ĸ�ʽ���ַ���,����ʽ����������ַʹ��<>������
     * @param internetAddress InternetAddress��ַ����
     * @return ��ʽ����ĵ�ַ��eg��johny <user1@test.com> �� user1@test.com ��
     *         ��InternetAddress����Ϊnull���򷵻�null
     */
    public static String defaultFormatInternetAddress(InternetAddress internetAddress) {
        return formatInternetAddress(internetAddress,INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX,INTERNET_ADDRESS_DEFAULT_FORMAT_SUFFIX);
    }

    /**
     * ��InternetAddress�����ʽ��Ϊ�磺johny ${internetAddressFormatPrefix}user1@test.com${internetAddressFormatSuffix}�����ĸ�ʽ���ַ���,����ʽ����������ַʹ��<>������
     * @param internetAddress InternetAddress��ַ����
     * @param internetAddressFormatPrefix ��ʽ�������ַ��ǰ׺������
     * @param internetAddressFormatSuffix ��ʽ�������ַ�ĺ�׺������
     * @return ��ʽ����ĵ�ַ��eg��johny ${internetAddressFormatPrefix}user1@test.com${internetAddressFormatSuffix} �� user1@test.com ��
     *         ��InternetAddress����Ϊnull���򷵻�null
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
        /*ԭʼ���������ţ�������գ���������һ��ʱ���ɾ��
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
     * �������ַ����ת��Ϊ�ַ���,����ռ���֮����";"�ָ�,�ռ��˵�ַ��"<"��">"������.
     * @param internetAddressCollection ��ַ����
     * @return ��ʽ����ĵ�ַ�ַ������磺����user1 <user1@test.com>; ����user2 <user2@test.com>; user3@test.com
     */
    public final static String defaultFormatInternetAddress(Collection<InternetAddress> internetAddressCollection) {
        return formatInternetAddress(internetAddressCollection, INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX, INTERNET_ADDRESS_DEFAULT_FORMAT_SUFFIX);
    }

    /**
     * �������ַ����ת��Ϊ�ַ���,����ռ���֮����";"�ָ�,�ռ��˵�ַ��"${internetAddressFormatPrefix}"��"${internetAddressFormatSuffix}"��������
     * @param internetAddressCollection InternetAddress��ַ����
     * @param internetAddressFormatPrefix ��ʽ�������ַ��ǰ׺������(��ַ����������֮��ķָ���)
     * @param internetAddressFormatSuffix ��ʽ�������ַ�ĺ�׺������(��ַ�Ľ�β�ָ���)
     * @return ��ʽ����ĵ�ַ�ַ������磺����user1 ${internetAddressFormatPrefix}user1@test.com${internetAddressFormatSuffix};user3@test.com
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
     * ��ʽ�������ַ������ռ���֮����";"�ָ�,�ռ��˵�ַ��"<"��">"����������ʹֻ��һ���ռ��˵�ַ��Ҳ����"<"��">"������
     * @param addressStr ʹ��";"�ָ��ĵ�ַ�ַ���
     * @return ���ر�׼�ľ�����ʽ����InternetAddress�ַ�����eg: johnny<user1@test.com>;<user2@test.com>
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
                        .replace(INTERNET_ADDRESS_DEFAULT_FORMAT_PREFIX, INTERNET_ADDRESS_FORMAT_SHOW_PREFIX) + "�����ַ��ʽ����ȷ";
                throw new Exception(msg,e);
            }
        }
        if(standardizationBuilder.length() > 0) {
            standardizationBuilder.deleteCharAt(standardizationBuilder.length() - 1);
        }
        return standardizationBuilder.toString();

        /*ԭʼ���������ţ�������գ���������һ��ʱ���ɾ��
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
                    throw new Exception(addresse.replace(">", "]").replace("<", "[") + "��Ч�����ַ");
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
     * ����";"�ָ����ַ����еĳ�ȡ���ʼ���ַ���Լ��ϵ���ʽ���ء�
     * eg: �ַ���Ϊ������user1<user1@test.com>;user2@test.com;<user3@test.com>
     *     �õ��Ľ���� user1@test.com��user2@test.com��user3@test.comΪԪ�صļ���
     * @param addressStr ʹ��";"�ָ��ĵ�ַ�ַ���
     * @return �����ַ�ļ���
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
     * ͳһ�ʼ���ַ�ָ���
     * @param mailAddress �ʼ���ַ�������ж��
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
