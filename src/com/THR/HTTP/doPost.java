package com.THR.HTTP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class doPost {


    public static void main(String args[]) throws Exception {
        String value = "{\"attachmentInfo\":\"�ʼ�������Ϣ3\",\"description\":\"�ʼ���־����3\",\"encrypted\":true,\"mailLogAddTime\":1516259788684,\"mailSecurityLevel\":{\"securityLevelId\":10},\"mailSenderInfo\":\"�ʼ�������3\",\"mailSubject\":\"�ʼ���־3\",\"mailToInfo\":\"�ʼ�������3\",\"mailUuId\":\"888888888888\",\"signed\":true}";
        String ip = "http://192.168.42.220/service/mailLogService";
        System.out.println("---------------post����-----------------");
        //System.out.println(readContentFromPost(ip, "data=" + URLEncoder.encode(value, "GBK")));
        //System.out.println("---------------get���� ----------------------");
        //System.out.println(readContentFromGet(ip, "data=" +  URLEncoder.encode(value, "GBK")));

        //ip = "http://192.168.42.220:8080/HttpProject/MailLogServlet";
        //System.out.println(readContentFromPost(ip, "data=" + URLEncoder.encode(value, "GBK")));

        String localUmaIp = "http://192.168.42.220:8080/service/mailLogService";
        System.out.println("---------------post����-----------------");
        System.out.println(readContentFromPost(localUmaIp, "data=" + URLEncoder.encode(value, "GBK")));
    }


    /**
     * ִ��post����
     * @param url �����ַ
     * @param paramValue �������ֵ
     * @return
     * @throws Exception
     */
    private static String readContentFromPost(String url , String paramValue) throws Exception {

        try {

            URL postUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) postUrl.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            //out.write(paramValue.getBytes("UTF-8"));
            //conn.setRequestProperty("Charset","utf-8");

            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(paramValue);
            out.flush();
            out.close(); // flush and close

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"GBK"));
                String line;
                StringBuffer result = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                reader.close();
                return result.toString();
            }else{
                Exception e = new Exception("Post��������ʧ��" + conn.getResponseCode());
                throw e;
            }
        } catch (Exception e) {
            throw  e;
        }
    }
    private static String readContentFromGet(String url , String paramValue) throws Exception {

        try {

            URL postUrl = new URL(url+"?"+paramValue);
            HttpURLConnection conn = (HttpURLConnection) postUrl.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");


            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"GBK"));
                String line;
                StringBuffer result = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                reader.close();
                return result.toString();
            }else{
                Exception e = new Exception("GET��������ʧ��" + conn.getResponseCode());
                throw e;
            }
        } catch (Exception e) {
            throw  e;
        }
    }
}
