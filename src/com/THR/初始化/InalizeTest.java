package com.THR.初始化;
import java.util.ArrayList;
import java.util.List;

public class InalizeTest {

    private void testOne(){
        int i;
        i = 1;
        testTwo(i);
    }
    private void testTwo(int i){

    }

    /**
     * 测试迭代删除list的元素
     */
    private static void testDelList(){
        List<String> iList = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            iList.add(String.valueOf(i));
        }

        for (String i : iList){
            if (i.equals("2")){
                iList.remove(i);
            }
            else{
                System.out.println(i);
            }
        }
    }

    public static void main(String args[]){
        //Integer ii = 3;
        //System.out.println(3==ii);
        //System.out.println("aa.bb.cc".split("\\.").length);

        testDelList();
        //System.out.println("---" + "abc".equals(""));
    }
}
