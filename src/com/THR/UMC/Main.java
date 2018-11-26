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

        applyAttach("www.test1.com", "192.168.42.220", "���Ե�λ1");

        addMailLog("www.test1.com","192.168.42.220", "bFAUihY1kwgIZQ/Tm3J38A==");
        addMailLog("www.test1.com","192.168.42.220", "KjPyfIQjHUA5EEzUr+mEAw==");

        System.out.println("---------------------------------------------------------------------------");
        deliverDataToUma("192.168.42.220", "datadata_KL!@0UM");
    }

    /**
     * �������UMC
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
        System.out.println("��������Url:" + url);
    }

    /**
     * �������ʼ���־
     * @param domain
     * @param ip
     * @param  attachCode δ���ܵĽ�����
     */
    public static void addMailLog(String domain, String ip, String attachCode) throws Exception {

        String igKey = getIllegalSecretKey(domain);
        String encryptIg = encrypt(igKey.getBytes(),"12345678");
        String ig = URLEncoder.encode(encryptIg,"GBK");

        String suffix = "3";
        EntityMailLog mailLog = new EntityMailLog();
        mailLog.setMailSubject("�ʼ���־" + suffix);
        EntitySecurityLevel securityLevel = new EntitySecurityLevel();
        securityLevel.setSecurityLevelId(10);
        mailLog.setMailSecurityLevel(securityLevel);
        mailLog.setAttachmentInfo("�ʼ�������Ϣ" + suffix);
        mailLog.setEncrypted(true);
        mailLog.setSigned(true);
        mailLog.setMailLogAddTime(new Date());
        mailLog.setMailSenderInfo("�ʼ�������" + suffix);
        mailLog.setMailToInfo("�ʼ�������" + suffix);
        mailLog.setMailUuId("888888888888");
        mailLog.setDescription("�ʼ���־����" + suffix);


        SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(EntityMailLog.class,
                "mailSubject", "mailSecurityLevel", "attachmentInfo", "encrypted", "signed", "mailLogAddTime",
                "mailSenderInfo", "mailToInfo", "mailUuId", "description");
        String formerData = JSON.toJSONString(mailLog, simplePropertyPreFilter);
        System.out.println("����ʼ���־data:" + formerData);

        attachCode =  decryptAttachCode(attachCode);
        String dataKey = getDataSecretKey(getSecretKeyPrefix(attachCode));
        String encryptData = encrypt(dataKey.getBytes(), formerData);
        String data = URLEncoder.encode(encryptData,"GBK");

        String url = "http://" + umcIp + "/service?t=e_addmaillog&domain=" + domain + "&data=" + data + "&ig=" + ig + "";
        System.out.println("�������ʼ���־��" + url);
    }


    /**
     * ģ���ʼ���UMA������
     * @param umaIp
     * @param  decryptCode δ���ܵĽ�����
     */
    public static void deliverDataToUma(String umaIp, String decryptCode) throws Exception {

        String suffix = "3";
        EntityMailLog mailLog = new EntityMailLog();
        mailLog.setMailSubject("�ʼ���־" + suffix);
        EntitySecurityLevel securityLevel = new EntitySecurityLevel();
        securityLevel.setSecurityLevelId(10);
        mailLog.setMailSecurityLevel(securityLevel);
        mailLog.setAttachmentInfo("�ʼ�������Ϣ" + suffix);
        mailLog.setEncrypted(true);
        mailLog.setSigned(true);
        mailLog.setMailLogAddTime(new Date());
        mailLog.setMailSenderInfo("�ʼ�������" + suffix);
        mailLog.setMailToInfo("�ʼ�������" + suffix);
        mailLog.setMailUuId("888888888888");
        mailLog.setDescription("�ʼ���־����" + suffix);


        SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(EntityMailLog.class,
                "mailSubject", "mailSecurityLevel", "attachmentInfo", "encrypted", "signed", "mailLogAddTime",
                "mailSenderInfo", "mailToInfo", "mailUuId", "description");
        String formerData = JSON.toJSONString(mailLog, simplePropertyPreFilter);
        System.out.println("����UMA�����ʼ���־data:" + formerData);

        //String encryptData = encrypt(decryptCode.getBytes(), formerData);
        //String data = URLEncoder.encode(encryptData,"GBK");
        String data = URLEncoder.encode(formerData,"GBK");
        System.out.println("��һ��encode:" + data);

        data = URLEncoder.encode(data,"GBK");
        System.out.println("��2��encode:" + data);

        String url = "http://" + umaIp + "/service/mailLogService?data=" + data + "";
        System.out.println("����UMA�����ʼ���־��" + url);
    }

}
