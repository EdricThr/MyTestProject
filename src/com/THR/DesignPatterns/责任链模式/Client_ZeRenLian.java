package com.THR.DesignPatterns.������ģʽ;

public class Client_ZeRenLian {

    public static void main(String args[]){
        Handler projectManager = new ProjectManager();
        Handler deptManager = new DeptManager();
        projectManager.setSuccessor(deptManager);

        System.out.println(projectManager.hadleFeeRequest("����", 400));
        System.out.println(projectManager.hadleFeeRequest("����", 400));
        System.out.println(projectManager.hadleFeeRequest("����", 600));
        System.out.println(projectManager.hadleFeeRequest("����", 600));
        System.out.println(projectManager.hadleFeeRequest("����", 1500));
        System.out.println(projectManager.hadleFeeRequest("����", 1500));
    }
}
