package com.THR.Json.FastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.Serializable;

public class TestFastJsonTwo {

    public static void main(String args[]){
        //String str = "{\"code\":\"110\",\"message\":\"�ʼ��ܿش���δ�Խ��ʼ�ϵͳ��ǶԽ��ʼ�ϵͳ����\",\"data\":\"110\"}";
        //String str = "{\"code\":\"110\",\"message\":\"�ʼ��ܿش���δ�Խ��ʼ�ϵͳ��ǶԽ��ʼ�ϵͳ����\"}";
        String str = "{\"code\":\"110\",\"message\":\"�ʼ��ܿش���δ�Խ��ʼ�ϵͳ��ǶԽ��ʼ�ϵͳ����\"}";
        HttpResponse httpResponse = JSON.parseObject(str, new TypeReference<HttpResponse>(){});
        System.out.println(httpResponse);

        //HttpResponse hp = new HttpResponse("code","message","data");
        //System.out.println(JSON.toJSONString(hp));
        //HttpResponse httpResponse2 = JSON.parseObject(JSON.toJSONString(hp), HttpResponse.class);



        //System.out.println(httpResponse2);
    }

    public static class HttpResponse implements Serializable {
        private String code;
        private String message;
        private String data;


        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

    }
}
