package com.THR.yamlTest;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class yaml {

    public static final String FIELD_USER_CODE = "user.code";
    public static final String FIELD_USER_NAME = "user.name";
    public static final String FIELD_USER_DEPT_CODE = "user.dept.code";
    public static final String FIELD_USER_DEPT_NAME = "user.dept.name";
    public static final String FIELD_USER_SECURITY_NAME = "user.security.name";
    public static final String FIELD_USER_LEVEL_NAME = "user.level.name";
    public static final String FIELD_USER_EXT_CODE = "user.ext.code";
    public static final String FIELD_USER_STATUS = "user.status";
    public static final String FIELD_USER_INDEX = "user.index";

    public static String[] fieldArray ={FIELD_USER_CODE,FIELD_USER_NAME,FIELD_USER_DEPT_CODE,FIELD_USER_DEPT_NAME,
            FIELD_USER_SECURITY_NAME,FIELD_USER_LEVEL_NAME,FIELD_USER_EXT_CODE,FIELD_USER_STATUS,FIELD_USER_INDEX};


    public static String respHeadSuccessXpath = "/respMsg/header/isSuccess";
    public static String respHeadMsgXpath = "/respMsg/header/message";
    public static String respHeadSysNameXpath = "/respMsg/header/sysName";
    public static String respDocumentXpath = "/respMsg/document";
    public static String respDocDeptXpath = "//dept";
    public static String respDocUserXpath = "//user";


    private static Map<String,String> COLUMN_MAP;

    public static String yamlPath = "D:\\Demo\\IdeaProjects\\Knowledge_Test\\src\\com\\yamlTest\\field_config.yaml";
    private static Pattern VAR_PATTERN = Pattern.compile("\\$\\{(.*?)\\}");
    private static final String VAR_BEGIN = "${";
    private static final String VAR_END = "}";

    public static String deptXmlString =  "<respMsg><header><sysName>APP_UUMS</sysName><isSuccess>true</isSuccess><message>操作成功</message></header><document><![CDATA[<depts><dept><dn>ou=130000,o=avic</dn><ou>130000</ou><avicDeptName>中国航空工业集团公司总部</avicDeptName><avicDeptCode>130000</avicDeptCode></dept><dept><dn>ou=130051,o=avic</dn><ou>130051</ou><avicDeptName>中航工业航空装备有限责任公司</avicDeptName><avicDeptCode>130051</avicDeptCode></dept><dept><dn>ou=130052,o=avic</dn><ou>130052</ou><avicDeptName>中航工业飞机有限责任公司</avicDeptName><avicDeptCode>130052</avicDeptCode></dept><dept><dn>ou=130053,o=avic</dn><ou>130053</ou><avicDeptName>中航工业发动机有限责任公司</avicDeptName><avicDeptCode>130053</avicDeptCode></dept><dept><dn>ou=130054,o=avic</dn><ou>130054</ou><avicDeptName>中航工业直升机有限责任公司</avicDeptName><avicDeptCode>130054</avicDeptCode></dept><dept><dn>ou=130056,o=avic</dn><ou>130056</ou><avicDeptName>中航工业通用飞机有限责任公司</avicDeptName><avicDeptCode>130056</avicDeptCode></dept><dept><dn>ou=130057,o=avic</dn><ou>130057</ou><avicDeptName>中航工业资产管理事业部</avicDeptName><avicDeptCode>130057</avicDeptCode></dept><dept><dn>ou=130058,o=avic</dn><ou>130058</ou><avicDeptName>中航工业国际控股有限责任公司</avicDeptName><avicDeptCode>130058</avicDeptCode></dept><dept><dn>ou=130059,o=avic</dn><ou>130059</ou><avicDeptName>中航工业基础技术研究院</avicDeptName><avicDeptCode>130059</avicDeptCode></dept><dept><dn>ou=130060,o=avic</dn><ou>130060</ou><avicDeptName>中航工业经济技术研究院</avicDeptName><avicDeptCode>130060</avicDeptCode></dept><dept><dn>ou=130061,o=avic</dn><ou>130061</ou><avicDeptName>中航工业投资控股有限公司</avicDeptName><avicDeptCode>130061</avicDeptCode></dept><dept><dn>ou=130062,o=avic</dn><ou>130062</ou><avicDeptName>中航工业汽车工业控股有限公司</avicDeptName><avicDeptCode>130062</avicDeptCode></dept><dept><dn>ou=130063,o=avic</dn><ou>130063</ou><avicDeptName>中航工业规划建设发展有限责任公司</avicDeptName><avicDeptCode>130063</avicDeptCode></dept><dept><dn>ou=130064,o=avic</dn><ou>130064</ou><avicDeptName>中航工业进出口有限责任公司</avicDeptName><avicDeptCode>130064</avicDeptCode></dept><dept><dn>ou=130065,o=avic</dn><ou>130065</ou><avicDeptName>中航工业航电系统公司</avicDeptName><avicDeptCode>130065</avicDeptCode></dept><dept><dn>ou=130066,o=avic</dn><ou>130066</ou><avicDeptName>中航工业机电系统公司</avicDeptName><avicDeptCode>130066</avicDeptCode></dept><dept><dn>ou=130630,o=avic</dn><ou>130630</ou><avicDeptName>中航工业飞行试验研究院</avicDeptName><avicDeptCode>130630</avicDeptCode></dept><dept><dn>ou=131883,o=avic</dn><ou>131883</ou><avicDeptName>中航工业商用航空发动机有限责任公司</avicDeptName><avicDeptCode>131883</avicDeptCode></dept><dept><dn>ou=131834,o=avic</dn><ou>131834</ou><avicDeptName>幸福航空有限责任公司</avicDeptName><avicDeptCode>131834</avicDeptCode></dept><dept><dn>ou=131810,o=avic</dn><ou>131810</ou><avicDeptName>中航工业重机股份有限公司</avicDeptName><avicDeptCode>131810</avicDeptCode></dept><dept><dn>ou=131320,o=avic</dn><ou>131320</ou><avicDeptName>江西洪都集团</avicDeptName><avicParentDeptCode>avic</avicParentDeptCode><avicDeptCode>131320</avicDeptCode></dept></depts>]]></document></respMsg>";
    public static String deptXmlString2 =
            "<respMsg>" +
            "  <header>" +
            "    <sysName>APP_UUMS</sysName>" +
            "    <isSuccess>true</isSuccess>" +
            "    <message>操作成功</message>" +
            "  </header>" +
            "  <document>" +
            "  <![CDATA[<depts>" +
            "  <dept>" +
                "  <avicDeptName>根部门</avicDeptName>" +
                "  <avicDeptCode>1111</avicDeptCode>" +
                "  <avicParentDeptCode></avicParentDeptCode>" +
                "  <avicDeptState>1</avicDeptState>" +
                "  <avicParentDeptName>根部门</avicParentDeptName>" +
                "  <avicSortOrder>1</avicSortOrder>" +
            "  </dept>" +
            "  <dept>" +
                "<avicDeptName>中航工业航空装备有限责任公司1</avicDeptName>" +
                "  <avicDeptCode>11112</avicDeptCode>" +
                "  <avicParentDeptCode>11113</avicParentDeptCode>" +
                "  <avicDeptState>1</avicDeptState>" +
                "  </dept>" +
            "  <dept>" +
            "<avicDeptName>一级部门1</avicDeptName>" +
            "  <avicDeptCode>11111</avicDeptCode>" +
            "  <avicParentDeptCode>1111</avicParentDeptCode>" +
            "  <avicDeptState>1</avicDeptState>" +
            "  </dept>" +
            "  <dept>" +
            "<avicDeptName>一级部门3</avicDeptName>" +
            "  <avicDeptCode>11113</avicDeptCode>" +
            "  <avicParentDeptCode>1111</avicParentDeptCode>" +
            "  <avicDeptState>1</avicDeptState>" +
            "  </dept>" +
            "  </depts>]]>" +
            "  </document>" +
            "</respMsg>";


    public static void main(String args[]) throws Exception {

        initColumnCfg();
        List<Map<String,String>> deptXmlDatas = parseDeptXml(deptXmlString.trim());
        for(Map<String,String> deptData : deptXmlDatas) {
            System.out.println("---------------------------------------");
            for (String field : fieldArray) {
                System.out.println(field + ":" + getFiledValue(field,deptData));
            }
        }
    }

    private static void initColumnCfg() throws Exception {
        Yaml yaml = new Yaml();
        Map<String,String> columnMap = yaml.loadAs(new FileInputStream(new File(yamlPath)), HashMap.class);
        if(MapUtils.isEmpty(columnMap)) {
            throw new Exception("配置列关系映射错误，请检查。");
        }
        COLUMN_MAP = Collections.unmodifiableMap(columnMap);
    }

    private static String getFiledValue(String filedName,Map<String,String> valueMap) {
        String filedMappingValue = COLUMN_MAP.get(filedName);
        if(filedMappingValue == null || filedMappingValue.trim().length() == 0) {
            return filedMappingValue;
        }
        Set<String> params = getRefVars(filedMappingValue.trim());
        if(null == params || params.isEmpty()) {
            return filedMappingValue;
        }
        String fieldFinalValue = filedMappingValue;
        for(String param : params) {
            if(null == param || "".equalsIgnoreCase(param.trim())) {
                continue;
            }
            String paramValue = valueMap.get(param.trim());
            paramValue = (paramValue != null) ? paramValue.trim() : "";
            fieldFinalValue = StringUtils.replace(fieldFinalValue, VAR_BEGIN + param + VAR_END, paramValue);
        }
        return fieldFinalValue;
    }

    /**
     * 获取"..${name1}...${name2}... "中这些被引用的名称的数组["name1", "name2", ..]
     * @param s
     * @return
     */
    private static final Set<String> getRefVars(String s) {
        Set<String> vars = new HashSet<>();
        Matcher m = VAR_PATTERN.matcher(s);
        while (m.find()) {
            vars.add(m.group(1));
        }
        return vars;
    }

    private static List<Map<String,String>> parseDeptXml(String deptXmlString) throws Exception {
        Element docElement = Dom4jUtil.getSingleElement(deptXmlString, respDocumentXpath);

        if(null != docElement) {
            return Dom4jUtil.getElementsDataList(docElement.getTextTrim(),respDocDeptXpath);
        }
        return Collections.emptyList();
    }
}
