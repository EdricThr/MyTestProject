package com.koal.�ӽ���;

/**
 * �����ʼ��������ӵ��ʱ�Ľ���
 *
 * @author Thr
 */
public class TestDec {

    public static void main(String args[]){
        doMailAppvoceLogin();
    }
    public static void doMailAppvoceLogin() {
        //String desStr = "n%2F40AU3ZJtw%3D";
        //String desStr = "NO4LeIYij%2BA%3D";
        String desStr = "0hLAilho7k4%3D";
        String approveProcessIdsStr = new String(DesUtil.decrypt(Base64.decode(desStr)));
        System.out.println(approveProcessIdsStr);
    }
}
