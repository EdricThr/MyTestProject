/**
 * File: DesUtil.java
 *
 * @author yzf
 * @version 1.1.0 2010-12-1
 *
 * Copyright (C) 2006,2007 , KOAL, Inc.
 */
package com.koal.�ӽ���;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * des���ܹ���
 * @author yzf
 *
 */
public class DesUtil
{    
	private static final Log log = LogFactory.getLog(DesUtil.class);
    //���� �����㷨,���� DES,DESede,Blowfish   
    private static final String Algorithm = "DESede";
         
    //keybyteΪ������Կ������Ϊ24�ֽ�   
    private static final byte[] keyBytes = {0x51, 0x52, 0x4F, 0x58, (byte)0x88, 0x10, 0x40, 0x38 
            , 0x28, 0x25, 0x79, 0x51, (byte)0xCB, (byte)0xDD, 0x55, 0x66
            , 0x77, 0x29, 0x74, (byte)0x98, 0x30, 0x40, 0x36, (byte)0xE2};
    
    
    //srcΪ�����ܵ����ݻ�������Դ��    
    public static byte[] encrypt(byte[] src) 
    {       
        return encrypt(keyBytes, src);   
    }    
    
    public static byte[] encrypt(byte[] keys, byte[] src) 
    {       
        try 
        {            
            //������Կ            
            SecretKey deskey = new SecretKeySpec(keys, Algorithm);
            //����           
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);       
        }
        catch (java.security.NoSuchAlgorithmException e1) 
        {          
            e1.printStackTrace(); 
            log.debug("�㷨�����ڣ�", e1);
        } 
        catch (javax.crypto.NoSuchPaddingException e2) 
        {         
            e2.printStackTrace(); 
            log.debug("�����ض������Ƶ�δ�ṩ��", e2);
        } 
        catch (java.lang.Exception e3)
        {
            e3.printStackTrace();
            log.debug("�����쳣��", e3);
        }
        return null;
    }

    //srcΪ���ܺ������
    public static byte[] decrypt(byte[] src)
    {
        return decrypt(keyBytes, src);
    }

    public static byte[] decrypt(byte[] keys, byte[] src)
    {
        try
        {
            //������Կ
            SecretKey deskey = new SecretKeySpec(keys, Algorithm);
            //����
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        }
        catch (java.security.NoSuchAlgorithmException e1)
        {
            e1.printStackTrace();
            log.debug("�㷨�����ڣ�", e1);
        }
        catch (javax.crypto.NoSuchPaddingException e2)
        {
            e2.printStackTrace();
            log.debug("�����ض������Ƶ��û�����δ�ṩ:", e2);
        }
        catch (java.lang.Exception e3)
        {            
            e3.printStackTrace(); 
            log.debug("�����쳣:", e3);
        }        
        return null;  
    } 
    
    /**
     * �������м��ܣ�ע�⣺��������ر��ɵ����߹������ڵ����߿�����׷��֮��Ĳ�����
     * @param inputStream
     * @param outputStream
     * @throws Exception
     */
    public static void encrypt(InputStream inputStream, OutputStream outputStream) throws Exception {
    	encrypt(keyBytes,inputStream,outputStream);
    }
    
    /**
     * �������м���,ע�⣺��������ر��ɵ����߹������ڵ����߿�����׷��֮��Ĳ�����
     * @param keys
     * @param inputStream
     * @param outputStream
     * @throws Exception
     */
	public static void encrypt(byte[] keys, InputStream inputStream, OutputStream outputStream) throws Exception {
		SecretKey secretKey = new SecretKeySpec(keys, Algorithm);
        Cipher cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        try(InputStream cin = new CipherInputStream(inputStream, cipher)){
        	byte[] buffer = new byte[1024];  
            int count = 0;  
            while ((count = cin.read(buffer)) > 0) {  
            	outputStream.write(buffer, 0, count);              
            } 
            outputStream.flush();
        }
        catch(Exception e) {
        	throw e;
        }
	}
    
	/**
	 * �������н��ܣ�ע�⣺��������ر��ɵ����߹������ڵ����߿�����׷��֮��Ĳ�����
	 * @param inputStream
	 * @param outputStream
	 * @throws Exception
	 */
	public static void decrypt(InputStream inputStream, OutputStream outputStream) throws Exception {
		decrypt(keyBytes,inputStream,outputStream);
	}
	
	/**
	 * �������н��ܣ�ע�⣺��������ر��ɵ����߹������ڵ����߿�����׷��֮��Ĳ�����
	 * @param keys
	 * @param inputStream
	 * @param outputStream
	 * @throws Exception
	 */
	public static void decrypt(byte[] keys, InputStream inputStream, OutputStream outputStream) throws Exception {
		SecretKey secretKey = new SecretKeySpec(keys, Algorithm);
        Cipher cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        try(OutputStream out = new CipherOutputStream(outputStream, cipher)){
        	byte[] buffer = new byte[1024];  
        	int count;
            while ((count = inputStream.read(buffer)) > 0) {  
            	out.write(buffer, 0, count);             
            }
            out.flush();
        }
        catch(Exception e) {
        	throw e;
        }
    }
	
	public static Cipher getEncryptKey(byte[] keys) throws Exception {
		SecretKey deskey = new SecretKeySpec(keys, Algorithm);
        Cipher cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        
        return cipher;
	}

    public static void main(String[] args) throws Exception
    {   
        /*System.out.println("���Լ����ַ���:" + new String(Base64.encode(encrypt("������С����������С����������С����������С����������С����������С����������С����������С����".getBytes()))));
        String szSrc = "Kmail54321@!"; 
        System.out.println("����ǰ���ַ���:" + szSrc);
        byte[] encoded = encrypt(szSrc.getBytes());
        String encodedB64 = new String(Base64.encode(encoded)); 
        System.out.println("���ܺ���ַ���:" + new String(encoded));    
        System.out.println("���ܺ���ַ���base64����:" + encodedB64);    
        String encodedUrl = URLEncoder.encode(encodedB64, "gbk"); 
        System.out.println("���ܺ���ַ���base64����+url����:" + encodedUrl); 
        byte[] srcBytes = decrypt(Base64.decode(encodedB64.getBytes()));
        System.out.println("base64������ܺ���ַ���:" + (new String(srcBytes))); 
        System.out.println("base64����+url������ܺ���ַ���:" + (new String(decrypt(Base64.decode(URLDecoder.decode("HxJkJQVaJ38%3D").getBytes()))))); 
        
        
        System.out.println(System.currentTimeMillis());
        
//        String decodeStr = new String(DesUtil.decrypt(szSrc.getBytes(),Base64.decode("7l3mqhtlz5zT4S2EE3BXO9fkdyx0P+1YKD3zUi8GptoVQI1v4VgFow==".getBytes())));
//        System.out.println(decodeStr);
        
        String ldapPwd = new String(DesUtil.decrypt(Base64.decode("hC8pooAhrey1SLCKaI02MA==")));
        System.out.println("ldapPwd:" + ldapPwd);
        System.out.println("ldapPwd md5:" + new String(SecureUtil.getMd5(ldapPwd)));
        
        String mailPwdKey = new String(DesUtil.decrypt(Base64.decode("Mq0WKczmJpvOFvhq73wfgMXdRkXkJ2untUiwimiNNjA=")));
        System.out.println("mailPwdKey:" + mailPwdKey);
        String mailPwd = new String(DesUtil.decrypt(mailPwdKey.getBytes(), Base64.decode("onjc0+xo6eW+kxpg/STVyQ==")));
        System.out.println("mailPwd:" + mailPwd);

        byte[] encryptKey = DesUtil.decrypt(Base64.decode("9svGdHx5KSIkRoHUTJso0Qko9nKuydPDtUiwimiNNjA=".getBytes()));
        String pwd = "testpwd";
        String pwdMd5 = SecureUtil.getMd5(pwd);
        String pwdEnc = new String(Base64.encode(DesUtil.encrypt(encryptKey, pwd.getBytes())));
        System.out.println("pwdMd5: " + pwdMd5);
        System.out.println("pwdEnc: " + pwdEnc);*/
    }

}
