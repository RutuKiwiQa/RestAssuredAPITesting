package com.restAssuredTests.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName) throws IOException {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static void getCellData(int rowNum, int colNum){
            DataFormatter formatter = new DataFormatter();
            Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
            System.out.println("Cell Data : " + value);
    }

    public static void getRowCount()  {
          //  String projDir = System.getProperty("user.dir"); //project's directory
            //System.out.println(projDir);
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of Rows : " + rowCount);
    }
}
