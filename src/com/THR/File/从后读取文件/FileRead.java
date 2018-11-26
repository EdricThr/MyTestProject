package com.THR.File.从后读取文件;


import com.base.util.Base64;

import java.io.*;

public class FileRead {

    public static void main(String args[]) throws Exception {

        doInsertTxt();
        doThings();
    }

    public static void doThings() {

        try {
            FileInputStream inputStream = new FileInputStream(new File("d:/data.log"));
            byte[] buf = new byte[inputStream.available()];
            //BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
            //String line = null;
            //while ((line = reader.readLine()) != null) {
            //    System.out.println(line + "\n");
            //}
            //

            inputStream.read(buf, 0, inputStream.available());

            //System.out.println("base64:" + new String(Base64.encode(buf)));
            System.out.println("String:" + new String(buf, "GBK"));
            //for (byte b : buf){
            //    System.out.print(b);
            //}
            //System.out.println();
            //System.out.println("buf.toString()" + buf.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doInsertTxt() throws Exception {

        File file  = new File("d:/data.log");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        InputStream inputStream;
        String str = "";
        try {
            inputStream = new FileInputStream(new File("d:/data"));
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b, 0, inputStream.available());
            str = new String(Base64.encode(b));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String users = "";
        String user = null;
        for (int i = 0; i < 100; i++) {
            user = "<user><cn>test"+ i +"</cn><fullName>测试用户"+ i +"</fullName><mail>test"+ i +"@thr.com</mail><avicDeptCode>11111</avicDeptCode><avicEmpNo>"+ i +"test</avicEmpNo><photo>"+ str +"</photo></user>";
            users += user;
        }

        String resultHF = "<respMsg>" +
                "  <header>" +
                "    <sysName>APP_UUMS</sysName>" +
                "    <isSuccess>true</isSuccess>" +
                "    <message>操作成功</message>" +
                "  </header>" +
                "  <document>" +
                "  <![CDATA[" +
                "  <users>" + users +
                "  </users>" +
                "  ]]>" +
                "  </document>" +
                "</respMsg>";



        System.out.println("resultHF:" + resultHF);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "GBK"));
        bw.write(resultHF, 0, resultHF.length());
        bw.flush();
        bw.close();
        //RandomAccessFile raf = new RandomAccessFile(file,"rw");
        //raf.writeBytes(resultHF);
        //raf.close();
    }
}
