package com.restAssuredTests.utils;

import java.io.IOException;

public class ExcelUtilsTest {
    public static String excelPath = "./data/TestData.xlsx"; //relative path of excel
    public static String sheetName = "Sheet1";

    public static void main(String[] args) throws IOException {
        ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
        excel.getRowCount();
        excel.getCellData(1,0);
        excel.getCellData(1,1);
        excel.getCellData(1,2);
    }
}
