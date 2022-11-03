package com.mln.utils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReaders {

    private ExcelReaders(){}

    public static List<Map<String,String>> getExcelDataAsMapList(String ExcelFileName, String SheetName) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") +"/src/test/resources/"+ExcelFileName);
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheet(SheetName);

        int iRowCount=	sheet.getLastRowNum();
        int iColCount = sheet.getRow(iRowCount).getLastCellNum();
        List<Map<String,String>>excelData = new ArrayList<Map<String, String>>();

        Map<String,String> excelDataMap;
        for (int iRow =1 ; iRow <=iRowCount; iRow++){
            excelDataMap = new HashMap<String,String>();
            for (int iCol =0 ; iCol <iColCount; iCol++){
                String key = sheet.getRow(0).getCell(iCol).getStringCellValue();
                String value= sheet.getRow(iRow).getCell(iCol).getStringCellValue();
                excelDataMap.put(key,value);
            }

           excelData.add(excelDataMap);
        }
        wb.close();
        return excelData;
    }

    public static String[][] getExcelDataMethod1(String ExcelFileName,String SheetName) throws IOException{

        FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir") +"/src/test/resources/"+ ExcelFileName);
        XSSFWorkbook wb = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = wb.getSheet(SheetName);
        int iRowCount=	sheet.getLastRowNum();
        int iColCount = sheet.getRow(iRowCount).getLastCellNum();

        Iterator<Row> rowIterator = sheet.rowIterator();
        String[][] ExcelData = new String[iRowCount][iColCount];
        int iRowNo =0;
        while(rowIterator.hasNext()){
            Row RowValue = rowIterator.next();
            Iterator<Cell> cellIterator= RowValue.iterator();

            int iColNo =0;
            if (iRowNo >0){
                while(cellIterator.hasNext()){
                    ExcelData[iRowNo-1][iColNo] = cellIterator.next().toString();
                    iColNo++;
                }
            }
            iRowNo++;
        }

        wb.close();
        return ExcelData;

    }
    public static String[][] getExcelDataMethod2(String ExcelFileName,String SheetName) throws IOException{

        FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir") +"/src/test/resources/"+ExcelFileName);
        XSSFWorkbook wb = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = wb.getSheet(SheetName);

        int iRowCount=	sheet.getLastRowNum();
        int iColCount = sheet.getRow(iRowCount).getLastCellNum();
        //System.out.println(iRowCount);
        //System.out.println(iColCount);

        String[][] ExcelData = new String[iRowCount][iColCount];
        for (int iRow =1 ; iRow <=iRowCount; iRow++){
            for (int iCol =0 ; iCol < iColCount; iCol++){
                ExcelData[iRow-1][iCol] = sheet.getRow(iRow).getCell(iCol).getStringCellValue();
            }
        }
        wb.close();
        return ExcelData;

    }
}

