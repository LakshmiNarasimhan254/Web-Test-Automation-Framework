package org.mln.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReaders {

    private ExcelReaders() {
    }

    static FileInputStream fileInputStream;
    static XSSFWorkbook wb;
    static XSSFSheet sheet;


    public static List<Map<String, String>> getExcelDataAsMapList(String excelFilePath, String excelSheetName) throws IOException {
        setExcelFile(excelFilePath, excelSheetName);
        int iRowCount = getExcelRowCount();
        List<Map<String, String>> excelData = new ArrayList<>();
        for (int iRow = 1; iRow <= iRowCount; iRow++) {
            excelData.add(getExcelRowAsMap(iRow));
        }
        flushExcel();
        return excelData;
    }


    public static String[][] getAnyExcelDataAs2DString(String excelFilePath, String excelSheetName) throws IOException {
        setExcelFile(excelFilePath, excelSheetName);
        int iRowCount = getExcelRowCount();
        int iColCount = getExcelColCount();

        Iterator<Row> rowIterator = sheet.rowIterator();
        String[][] excelData = new String[iRowCount][iColCount];
        int iRowNo = 0;
        while (rowIterator.hasNext()) {
            Row rowValue = rowIterator.next();
            Iterator<Cell> cellIterator = rowValue.iterator();

            int iColNo = 0;
            if (iRowNo > 0) {
                while (cellIterator.hasNext()) {
                    excelData[iRowNo - 1][iColNo] = cellIterator.next().toString();
                    iColNo++;
                }
            }
            iRowNo++;
        }

        flushExcel();
        return excelData;

    }

    public static String[][] getExcelDataMethod2(String excelFilePath, String excelSheetName) throws IOException {
        setExcelFile(excelFilePath, excelSheetName);
        int iRowCount = getExcelRowCount();
        int iColCount = getExcelColCount();


        String[][] excelData = new String[iRowCount][iColCount];
        for (int iRow = 1; iRow <= iRowCount; iRow++) {
            for (int iCol = 0; iCol < iColCount; iCol++) {
                excelData[iRow - 1][iCol] = sheet.getRow(iRow).getCell(iCol).getStringCellValue();
            }
        }
        flushExcel();
        return excelData;

    }

    public static Object[][] getExcelData(String excelFilePath, String excelSheetName) throws IOException {
        setExcelFile(excelFilePath, excelSheetName);
        int iRowCount = getExcelRowCount();
        Object[][] excelData = new Object[iRowCount][iRowCount];
        for (int iRow = 1; iRow <= iRowCount; iRow++) {

            excelData[iRow - 1][0] = iRow;
            excelData[iRow - 1][1] = getExcelRowAsMap(iRow);
        }
        flushExcel();
        return excelData;
    }


    private static void setExcelFile(String excelFilePath, String excelSheetName) throws IOException {
        fileInputStream = new FileInputStream(excelFilePath);
        wb = new XSSFWorkbook(fileInputStream);
        sheet = wb.getSheet(excelSheetName);
    }

    private static int getExcelRowCount() throws IOException {
      return sheet.getLastRowNum();
    }

    private static int getExcelColCount() throws IOException {
         return sheet.getRow(getExcelRowCount()).getLastCellNum();
    }

    private static Map<String, String> getExcelRowAsMap(int excelRow) throws IOException {
        Map<String, String> excelRowMap = new HashMap<>();
        int iColCount = getExcelColCount();
        for (int iCol = 0; iCol < iColCount; iCol++) {
            String key = sheet.getRow(0).getCell(iCol).getStringCellValue();
            String value = sheet.getRow(excelRow).getCell(iCol).getStringCellValue();
            excelRowMap.put(key, value);
        }

        return excelRowMap;

    }

    private static void flushExcel() throws IOException {
        sheet = null;
        wb.close();
        fileInputStream.close();
    }


}




