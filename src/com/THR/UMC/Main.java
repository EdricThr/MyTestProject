package com.THR.UMC;

import com.THR.UMC.Entity.EntityMailLog;
import com.THR.UMC.Entity.EntitySecurityLevel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.net.URLEncoder;
import java.util.Date;

import static com.base.util.DecrypeAndEncryptUtil.*;

public class Main {

    private static String umcIp = "192.168.42.222:8080";

    public static void main(String args[]) throws Exception {

        applyAttach("www.test1.com", "192.168.42.220", "测试单位1");

        addMailLog("www.test1.com","192.168.42.220", "bFAUihY1kwgIZQ/Tm3J38A==");
        addMailLog("www.test1.com","192.168.42.220", "KjPyfIQjHUA5EEzUr+mEAw==");

        System.out.println("---------------------------------------------------------------------------");
        deliverDataToUma("192.168.42.220", "datadata_KL!@0UM");
    }

    /**
     * 申请接入UMC
     * @param domain
     * @param ip
     * @param comName
     * @throws Exception
     */
    public static void applyAttach(String domain, String ip, String comName) throws Exception {

        String igKey = getIllegalSecretKey(domain);
        String encryptIg = encrypt(igKey.getBytes(),"12345678");
        String ig = URLEncoder.encode(encryptIg,"GBK");

        String dataKey = getDataSecretKey(getSecretKeyPrefix(domain));
        String data = "{\"ip\":\"" + ip + "\",\"name\":\"" + comName + "\"}";
        data = encrypt(dataKey.getBytes(), data);
        data = URLEncoder.encode(data,"GBK");

        String url = "http://" + umcIp + "/service?t=e_applyattach&domain=" + domain + "&data=" + data + "&ig=" + ig + "";
        System.out.println("申请接入的Url:" + url);
    }

    /**
     * 添加域间邮件日志
     * @param domain
     * @param ip
     * @param  attachCode 未解密的接入码
     */
    public static void addMailLog(String domain, String ip, String attachCode) throws Exception {

        String igKey = getIllegalSecretKey(domain);
        String encryptIg = encrypt(igKey.getBytes(),"12345678");
        String ig = URLEncoder.encode(encryptIg,"GBK");

        String suffix = "3";
        EntityMailLog mailLog = new EntityMailLog();
        mailLog.setMailSubject("邮件日志" + suffix);
        EntitySecurityLevel securityLevel = new EntitySecurityLevel();
        securityLevel.setSecurityLevelId(10);
        mailLog.setMailSecurityLevel(securityLevel);
        mailLog.setAttachmentInfo("邮件附件信息" + suffix);
        mailLog.setEncrypted(true);
        mailLog.setSigned(true);
        mailLog.setMailLogAddTime(new Date());
        mailLog.setMailSenderInfo("邮件发送者" + suffix);
        mailLog.setMailToInfo("邮件接收者" + suffix);
        mailLog.setMailUuId("888888888888");
        mailLog.setDescription("邮件日志描述" + suffix);


        SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(EntityMailLog.class,
                "mailSubject", "mailSecurityLevel", "attachmentInfo", "encrypted", "signed", "mailLogAddTime",
                "mailSenderInfo", "mailToInfo", "mailUuId", "description");
        String formerData = JSON.toJSONString(mailLog, simplePropertyPreFilter);
        System.out.println("添加邮件日志data:" + formerData);

        attachCode =  decryptAttachCode(attachCode);
        String dataKey = getDataSecretKey(getSecretKeyPrefix(attachCode));
        String encryptData = encrypt(dataKey.getBytes(), formerData);
        String data = URLEncoder.encode(encryptData,"GBK");

        String url = "http://" + umcIp + "/service?t=e_addmaillog&domain=" + domain + "&data=" + data + "&ig=" + ig + "";
        System.out.println("添加域间邮件日志：" + url);
    }


    /**
     * 模拟邮件对UMA的请求
     * @param umaIp
     * @param  decryptCode 未解密的接入码
     */
    public static void deliverDataToUma(String umaIp, String decryptCode) throws Exception {

        String suffix = "3";
        EntityMailLog mailLog = new EntityMailLog();
        mailLog.setMailSubject("邮件日志" + suffix);
        EntitySecurityLevel securityLevel = new EntitySecurityLevel();
        securityLevel.setSecurityLevelId(10);
        mailLog.setMailSecurityLevel(securityLevel);
        mailLog.setAttachmentInfo("邮件附件信息" + suffix);
        mailLog.setEncrypted(true);
        mailLog.setSigned(true);
        mailLog.setMailLogAddTime(new Date());
        mailLog.setMailSenderInfo("邮件发送者" + suffix);
        mailLog.setMailToInfo("邮件接收者" + suffix);
        mailLog.setMailUuId("888888888888");
        mailLog.setDescription("邮件日志描述" + suffix);


        SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(EntityMailLog.class,
                "mailSubject", "mailSecurityLevel", "attachmentInfo", "encrypted", "signed", "mailLogAddTime",
                "mailSenderInfo", "mailToInfo", "mailUuId", "description");
        String formerData = JSON.toJSONString(mailLog, simplePropertyPreFilter);
        System.out.println("请求UMA处理邮件日志data:" + formerData);

        //String encryptData = encrypt(decryptCode.getBytes(), formerData);
        //String data = URLEncoder.encode(encryptData,"GBK");
        String data = URLEncoder.encode(formerData,"GBK");
        System.out.println("第一次encode:" + data);

        data = URLEncoder.encode(data,"GBK");
        System.out.println("第2次encode:" + data);

        String url = "http://" + umaIp + "/service/mailLogService?data=" + data + "";
        System.out.println("请求UMA处理邮件日志：" + url);
    }

}
