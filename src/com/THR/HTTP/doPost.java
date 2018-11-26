package com.THR.HTTP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class doPost {


    public static void main(String args[]) throws Exception {
        String value = "{\"attachmentInfo\":\"邮件附件信息3\",\"description\":\"邮件日志描述3\",\"encrypted\":true,\"mailLogAddTime\":1516259788684,\"mailSecurityLevel\":{\"securityLevelId\":10},\"mailSenderInfo\":\"邮件发送者3\",\"mailSubject\":\"邮件日志3\",\"mailToInfo\":\"邮件接收者3\",\"mailUuId\":\"888888888888\",\"signed\":true}";
        String ip = "http://192.168.42.220/service/mailLogService";
        System.out.println("---------------post请求-----------------");
        //System.out.println(readContentFromPost(ip, "data=" + URLEncoder.encode(value, "GBK")));
        //System.out.println("---------------get请求 ----------------------");
        //System.out.println(readContentFromGet(ip, "data=" +  URLEncoder.encode(value, "GBK")));

        //ip = "http://192.168.42.220:8080/HttpProject/MailLogServlet";
        //System.out.println(readContentFromPost(ip, "data=" + URLEncoder.encode(value, "GBK")));

        String localUmaIp = "http://192.168.42.220:8080/service/mailLogService";
        System.out.println("---------------post请求-----------------");
        System.out.println(readContentFromPost(localUmaIp, "data=" + URLEncoder.encode(value, "GBK")));
    }


    /**
     * 执行post请求
     * @param url 请求地址
     * @param paramValue 请求参数值
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
                Exception e = new Exception("Post请求数据失败" + conn.getResponseCode());
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
                Exception e = new Exception("GET请求数据失败" + conn.getResponseCode());
                throw e;
            }
        } catch (Exception e) {
            throw  e;
        }
    }
}
