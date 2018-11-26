package com.THR.DesignPatterns.工厂模式;

public class ExportPdfFinancial implements ExportDocType {
    @Override
    public void export() {
        System.out.println("-----PDF------财务模板-------");
    }
}
