package com.THR.DesignPatterns.工厂模式;

public interface ExportFileTypeFactory {
    ExportDocType factory(String type) throws Exception;
}
