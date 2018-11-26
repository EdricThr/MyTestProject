package com.THR.DesignPatterns.责任链模式;

public class Client_ZeRenLian {

    public static void main(String args[]){
        Handler projectManager = new ProjectManager();
        Handler deptManager = new DeptManager();
        projectManager.setSuccessor(deptManager);

        System.out.println(projectManager.hadleFeeRequest("张三", 400));
        System.out.println(projectManager.hadleFeeRequest("李四", 400));
        System.out.println(projectManager.hadleFeeRequest("张三", 600));
        System.out.println(projectManager.hadleFeeRequest("李四", 600));
        System.out.println(projectManager.hadleFeeRequest("张三", 1500));
        System.out.println(projectManager.hadleFeeRequest("李四", 1500));
    }
}
