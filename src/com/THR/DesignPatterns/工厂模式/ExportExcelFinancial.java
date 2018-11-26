package com.THR.DesignPatterns.工厂模式;

public class ExportExcelFinancial implements ExportDocType {
    @Override
    public void export() {
        System.out.println("-----Excel------财务模板-------");
    }
}
