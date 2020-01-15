package com.bridgelabiz.generic;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.FileInputStream;
import java.util.Properties;

public class Library implements IAutoConstant{
    public static Workbook workbook;
    public static XSSFSheet sheet;
    public static String getProperty(String CONFIG_PATH, String key)
    {
        String property = "";
        Properties prop = new Properties();

        try
        {
            prop.load(new FileInputStream(CONFIG_PATH));
            property = prop.getProperty(key);
            System.out.println(property);
        }
        catch(Exception e)
        {e.printStackTrace();}

        return property;
    }

    public static int getRowCount(String EXCEL_PATH,String sheet)
    {
        int row =0;
       try
        {
            workbook = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
            row = workbook.getSheet(sheet).getLastRowNum();
        }
        catch(Exception e) {e.printStackTrace();}
        return row;
    }


   public static String getCellValue(String EXCEL_PATH ,String sheet, int row , int column)
    {
        String value = "";
        try
        {
            workbook = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
            value = workbook.getSheet(sheet).getRow(row).getCell(column).toString();

        }
        catch(Exception e)
        {
            e.printStackTrace();}
        return value;
    }

   /* public String getData(int sheetnumber, int row, int column)
    {
        sheet = (XSSFSheet) workbook.getSheetAt(sheetnumber);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }*/
}
