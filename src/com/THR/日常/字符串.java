package com.THR.�ճ�;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.json.JSONException;

/**
 * @author Thr
 */
public class �ַ��� {

    public static void main(String args[]) throws JSONException {
        //String str = null;
        //System.out.println(str.toString());
        Object obj = null;
        System.out.println((String)obj);
        Object json = "{\"a\":\"ccc\"}";
        //JSONObject jsonObject = new JSONObject(json);

        JSONObject jsonObject = JSONObject.parseObject((String) json);
        System.out.println(jsonObject.get("abc"));

        String mailbox = "aabbcc@qq.com";
        System.out.println(mailbox.substring(0, mailbox.indexOf("@")));
        //System.out.println(String.valueOf(null));
    }
    public static void doStr() {
        String dept = "<ReqMsg><header><sendSysName></sendSysName><rcvSysName></rcvSysName><isSuccess>true</isSuccess></header><document><![CDATA[<depts><dept><avicDeptCode>1111</avicDeptCode><avicDeptName>������</avicDeptName><avicParentDeptCode>1111</avicParentDeptCode><avicDeptState>1</avicDeptState></dept><dept><avicDeptCode>11</avicDeptCode><avicDeptName>һ������1</avicDeptName><avicParentDeptCode>1111</avicParentDeptCode><avicDeptState>1</avicDeptState></dept></depts>]]></document></ReqMsg>";
        String user = "<ReqMsg><header><sendSysName></sendSysName><rcvSysName></rcvSysName><isSuccess>true</isSuccess></header><document><![CDATA[<users><user><cn>����user1</cn><fullname>11����user1</fullname><mail>user1@thr.com</mail><avicDeptCode>11</avicDeptCode></user><user><cn>����user2</cn><fullname>22����user2</fullname><mail>user2@thr.com</mail><avicDeptCode>11</avicDeptCode></user></users>]]></document></ReqMsg>";
    }
}
