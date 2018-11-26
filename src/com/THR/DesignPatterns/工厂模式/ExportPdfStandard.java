package com.THR.DesignPatterns.工厂模式;

public class ExportPdfStandard implements ExportDocType {
    @Override
    public void export() {
        System.out.println("-----PDF------标准模板-------");
    }
}
