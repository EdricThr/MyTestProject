package com.THR.DesignPatterns.����ģʽ;

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
