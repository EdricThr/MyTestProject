package com.THR.DesignPatterns.工厂模式;

public class ExportExcelStandard implements ExportDocType {
    @Override
    public void export() {
        System.out.println("-----Excel------标准模板-------");
    }
}
