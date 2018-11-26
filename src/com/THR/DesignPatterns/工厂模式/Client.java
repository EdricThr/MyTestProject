package com.THR.DesignPatterns.����ģʽ;

public class Client {

    public static void main(String args[]) throws Exception {
        ExportFileTypeFactory exportFileTypePdfFactory = new ExportFileTypePdfFactory();
        ExportDocType financialPdf = exportFileTypePdfFactory.factory("FINANCIAL");
        financialPdf.export();
    }
}
