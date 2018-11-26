package com.THR.File.从后读取文件;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class TestRandomAcccessFile {

    public static void main(String args[]) throws Exception {
        File file  = new File("d:/mylog.log");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        byte[] b = new byte[(int) raf.length()];
        raf.read(b,0,b.length);
        System.out.println(b);
        for (int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }
        raf.seek(0);
        long fileLength =  raf.length();
        long start = raf.getFilePointer();
        long readIndex = start + fileLength - 1;
        if (readIndex <= 0){
            return;
        }
        String line;
        raf.seek(readIndex);
        int c = -1;
        while (readIndex > start){
            c = raf.read();
            if (c == '\n' || c == '\r'){
                line = raf.readLine();
                if (null != line){
                    System.out.println("------" + line + "+");
                }
                readIndex --;
            }
            readIndex --;
            raf.seek(readIndex);
            if (readIndex == 0){
                System.out.println("------" + raf.readLine());
            }
        }
    }
}
