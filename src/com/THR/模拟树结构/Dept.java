package com.THR.Ä£ÄâÊ÷½á¹¹;

import java.util.HashMap;
import java.util.Map;

public class Dept {
    private Map<String, Dept> childDepts = new HashMap<>();
    private String pDeptId;
    private String deptId;
    private String deptName;

    public Dept(){}

    public Dept(String pDeptId, String deptId, String deptName) {
        this.pDeptId = pDeptId;
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public void addChildDept(Dept dept) {
        if (null != dept){
            childDepts.put(dept.getDeptId(), dept);
        }
    }

    public boolean hasChildDept(){
        return !childDepts.isEmpty();
    }

    public Map<String, Dept> getChildDepts() {
        return childDepts;
    }

    public void setChildDepts(Map<String, Dept> childDepts) {
        this.childDepts = childDepts;
    }

    public String getpDeptId() {
        return pDeptId;
    }

    public void setpDeptId(String pDeptId) {
        this.pDeptId = pDeptId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    @Override
    public String toString() {
        return "Dept{" +
                " pDeptId='" + pDeptId + '\'' +
                ", deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
