package org.mln.factory.datafactory;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mln.constants.FrameworkConstants;
import org.mln.utils.ExcelReaders;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataProvider {

    private ExcelDataProvider(){}
    @DataProvider(parallel = true)
    public static Object[][] getExcelData(Method method) throws IOException {
         return ExcelReaders.getExcelData(FrameworkConstants.getTestResourcePath()+"excel/TestData.xlsx",method.getName());
    }
}
