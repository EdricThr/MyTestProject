package com.THR.DesignPatterns.������ģʽ;

public class DeptManager extends Handler {
    
    
    @Override
    public String hadleFeeRequest(String user, double fee) {
        
        String result = "";
        
        if (fee < 1000) {
            if ("����".equals(user)) {
                result = "�ɹ������ž���ͬ����" + user + "�ľ۲����󣬽��Ϊ" + fee + "Ԫ";
            } else {
                result = "ʧ�ܣ����ž���ܾ���" + user + "�ľ۲����󣬽��Ϊ" + fee + "Ԫ";
            }
        }else{
            if (getSuccessor() != null) {
                return getSuccessor().hadleFeeRequest(user, fee);
            }
        }
        
        return result;
    }
}
