package com.THR.DesignPatterns.������ģʽ;

public class ProjectManager extends Handler {


    @Override
    public String hadleFeeRequest(String user, double fee) {

        String result = "";

        if (fee < 500) {
            if ("����".equals(user)) {
                result = "�ɹ�����Ŀ����ͬ����" + user + "�ľ۲����󣬽��Ϊ" + fee + "Ԫ";
            } else {
                result = "ʧ�ܣ���Ŀ����ܾ���" + user + "�ľ۲����󣬽��Ϊ" + fee + "Ԫ";
            }
        }else{
            if (getSuccessor() != null) {
                return getSuccessor().hadleFeeRequest(user, fee);
            }
        }

        return result;
    }
}
