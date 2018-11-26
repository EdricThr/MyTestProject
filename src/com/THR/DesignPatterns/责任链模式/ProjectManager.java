package com.THR.DesignPatterns.责任链模式;

public class ProjectManager extends Handler {


    @Override
    public String hadleFeeRequest(String user, double fee) {

        String result = "";

        if (fee < 500) {
            if ("张三".equals(user)) {
                result = "成功，项目经理同意了" + user + "的聚餐请求，金额为" + fee + "元";
            } else {
                result = "失败，项目经理拒绝了" + user + "的聚餐请求，金额为" + fee + "元";
            }
        }else{
            if (getSuccessor() != null) {
                return getSuccessor().hadleFeeRequest(user, fee);
            }
        }

        return result;
    }
}
