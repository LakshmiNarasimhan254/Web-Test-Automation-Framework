package org.mln.factory.datafactory;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mln.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataProvider {

    private ExcelDataProvider(){}
    @DataProvider(parallel = false)
    public static Object[][] getExcelData(Method method) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getTestResourcePath()+"testdata/excel/TestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheet(method.getName());

        int iRowCount=	sheet.getLastRowNum();
        int iColCount = sheet.getRow(iRowCount).getLastCellNum();
        Object[][]excelData = new Object[iRowCount][iRowCount];
        Map<String,String> excelDataMap;
        for (int iRow =1 ; iRow <=iRowCount; iRow++){
             excelDataMap = new HashMap<>();
            for (int iCol =0 ; iCol <iColCount; iCol++){
                String key = sheet.getRow(0).getCell(iCol).getStringCellValue();
                String value= sheet.getRow(iRow).getCell(iCol).getStringCellValue();
                excelDataMap.put(key,value);


            }
            excelData[iRow-1][0]= iRow;
            excelData[iRow-1][1] =excelDataMap;
        }

        return excelData;
    }
}
