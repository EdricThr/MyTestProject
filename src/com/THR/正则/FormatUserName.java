package com.THR.����;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ƥ��Matcher
 *
 * @author Thr
 */
public class FormatUserName {

    public static void main(String args[]){
        //testInvalidStr1();
        //testInvalidStr();
        //testInvalidStr12();

        doTestLazy();
        //String str = "<   script>";
        //System.out.println(checkValueXss(str));

        //checkValueXssReplace();
    }

    public static void doTestLazy() {
        String str = "<script>bb</script>cc";
        Pattern pattern = Pattern.compile("<.*>");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        System.out.println("--------------");
        pattern = Pattern.compile("<.*?>");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        System.out.println("--------------");
        pattern = Pattern.compile("<.*>bb");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        System.out.println("--------------");
        pattern = Pattern.compile("<.*?>cc");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

    public static void checkValueXssReplace() {
        Pattern pattern = Pattern.compile("<\\d*?script[^>]*?>",Pattern.CASE_INSENSITIVE);
        String str = "888<222scriptii>";
        StringBuffer sb = new StringBuffer();
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
        while(matcher.find()) {
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }

    private static boolean checkValueXss(String value) {
        //<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>
        //�������<script>��صĲ���ͨ�����
        Pattern pattern = Pattern.compile("<\\s*?script[^>]*?>",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        //System.out.println("---" + matcher.matches());
        if(matcher.find()) {
            return false;
        }
        pattern = Pattern.compile("<\\s*?\\/\\s*?script\\s*?>",Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(value);
        if(matcher.find()) {
            return false;
        }
        return true;
    }

    public static void testInvalidStr12() {
        Pattern pattern = Pattern.compile("<[\\s\\S]*>",Pattern.CASE_INSENSITIVE);
        //Pattern pattern = Pattern.compile("([\\s\\S]+[or][\\s\\S]+)");
        String str = "<rrrrrrrrrr��fdasfdadf/><eeeeeeeeee";
        Matcher matcher = pattern.matcher(str);
        //System.out.println(matcher.find());
        StringBuffer sb = new StringBuffer();
        //System.out.println(matcher.matches());
        while(matcher.find()) {
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }

    /**
     * ƥ��xxxx<xxxx/>xxxx
     */
    public static void testInvalidStr1() {
        //Pattern pattern = Pattern.compile("^([\\s\\S]*[<][\\s\\S]*[>][\\s\\S]*)$");
        Pattern pattern = Pattern.compile("^(.*[<].*[/][>].*)$");
        String str = "<rrrrrrrrrr��fdasfdadf/><eeeeeeeeee";
        StringBuffer sb = new StringBuffer();
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
        while(matcher.find()) {
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
    public static void testInvalidStr() {
        //Pattern pattern = Pattern.compile("([(��][^(��]*[)��])|([0-9]+)");
        Pattern pattern = Pattern.compile("([(��][^(��]*[)��])|([0-9]+)");
        //Pattern pattern = Pattern.compile("([(��][)��])");
        String str = "(ss��888iiii)606hahahah444";
        StringBuffer sb = new StringBuffer();
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }

    /**
     * ĳ�ʼ�ϵͳͬ���ַ���ͨ�������滻�ַ�
     */
    public static void testUsyncReplace() {
        //Pattern pattern = Pattern.compile("([(��][^(��]*[)��])|([0-9]+)");
        Pattern pattern = Pattern.compile("([(��][^(��]*[)��])|([0-9]+)");
        //Pattern pattern = Pattern.compile("([(��][)��])");
        String userName = "(ss��888)606hahahah444";
        Matcher matcher = pattern.matcher(userName);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }

    //�ж��ַ����Ƿ����email��ʽ
    public static boolean isEmail(String emailStr)
    {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]\\w*([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
//    Pattern p = Pattern.compile("^[a-zA-Z\\d][a-zA-Z\\d-_]*@([a-zA-Z\\d]([a-zA-Z\\d\\-]{0,61}[a-zA-Z\\d])?\\.)+[a-zA-Z]{2,6}$");
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
}
