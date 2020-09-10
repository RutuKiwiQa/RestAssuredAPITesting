package com.restAssuredTests.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    public static void main(String[] args) {
        getRowCount();
        getCellData();
    }

    public static void getCellData(){
        try {

            String excelPath = "./data/TestData.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheet("Sheet1");


            DataFormatter formatter = new DataFormatter();
            Object value = formatter.formatCellValue(sheet.getRow(1).getCell(1));

          //  Double value = sheet.getRow(1).getCell(2).getNumericCellValue();
            // String value = sheet.getRow(1).getCell(0).getStringCellValue();
            System.out.println("Cell Data : " + value);

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static void getRowCount()  {
        try {
          //  String projDir = System.getProperty("user.dir"); //project's directory
            //System.out.println(projDir);

            //String excelPath = projDir + "/data/TestData.xlsx"; //relative path of excel
            String excelPath = "./data/TestData.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of Rows : " + rowCount);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }

    }
}
