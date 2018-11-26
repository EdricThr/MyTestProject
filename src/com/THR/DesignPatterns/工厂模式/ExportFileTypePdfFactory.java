package com.THR.DesignPatterns.����ģʽ;

public class ExportFileTypePdfFactory implements ExportFileTypeFactory {
    @Override
    public ExportDocType factory(String type) throws Exception {
        if ("FINANCIAL".equals(type)) {
            return new ExportPdfFinancial();
        }else if ("STANDARD".equals(type)) {
            return new ExportPdfStandard();
        }else {
            throw new Exception();
        }
    }
}
