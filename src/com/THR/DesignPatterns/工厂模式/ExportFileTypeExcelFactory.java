package com.THR.DesignPatterns.工厂模式;

public class ExportFileTypeExcelFactory implements ExportFileTypeFactory {
    @Override
    public ExportDocType factory(String type) throws Exception {
        if ("FINANCIAL".equals(type)) {
            return new ExportExcelFinancial();
        }else if ("STANDARD".equals(type)) {
            return new ExportExcelStandard();
        }else {
            throw new Exception();
        }
    }
}
