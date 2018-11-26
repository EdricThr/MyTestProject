package com.THR.模拟树结构;

import java.util.HashMap;
import java.util.Map;

public class TestDeptTreeClient {

    public static void main(String args[]){

        Map<String, Dept> deptMap = new HashMap<>();
        Dept rootDept = new Dept("999999", "999999", "根部门");
        Dept oneDept1 = new Dept("999999", "1" , "一级部门1");
        Dept OneDept11 = new Dept("1", "11" , "二级部门11");
        Dept OneDept12 = new Dept("1", "12" , "二级部门12");
        Dept OneDept121 = new Dept("12", "121" , "三级部门121");

        Dept oneDept2 = new Dept("999999", "2" , "一级部门2");
        Dept OneDept21 = new Dept("2", "21" , "二级部门21");

        Dept oneDept3 = new Dept("999999", "3" , "一级部门3");

        deptMap.put(rootDept.getDeptId(), rootDept);
        deptMap.put(oneDept1.getDeptId(), oneDept1);
        deptMap.put(oneDept2.getDeptId(), oneDept2);
        deptMap.put(oneDept3.getDeptId(), oneDept3);
        deptMap.put(OneDept11.getDeptId(), OneDept11);
        deptMap.put(OneDept21.getDeptId(), OneDept21);
        deptMap.put(OneDept12.getDeptId(), OneDept12);
        deptMap.put(OneDept121.getDeptId(), OneDept121);

        for (Map.Entry<String, Dept> dept : deptMap.entrySet()) {
            String pId = dept.getValue().getpDeptId();
            if (pId.equals(dept.getValue().getDeptId())){
                continue;
            }
            if (null !=deptMap.get(pId)) {
                deptMap.get(pId).addChildDept(dept.getValue());
            }
        }

        //outputDept(deptMap.get("999999"));
        outputDept(rootDept);
    }

    private static void outputDept(Dept dept) {
        System.out.println(dept);
        if (dept.hasChildDept()) {
            for (Map.Entry<String, Dept> entry : dept.getChildDepts().entrySet()) {
                outputDept(entry.getValue());
            }
        }
    }
}
