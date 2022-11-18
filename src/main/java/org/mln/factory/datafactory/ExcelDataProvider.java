package org.mln.factory.datafactory;


import org.mln.constants.FrameworkConstants;
import org.mln.utils.ExcelUtil;
import org.testng.annotations.DataProvider;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ExcelDataProvider {
    private static List<Map<String, String>> actualExcelData = new ArrayList<>();

    private ExcelDataProvider() {
    }


    @DataProvider(parallel = true)
    public static Object[][] getExcelData(Method method)  {
        String testName = method.getName();
        if (actualExcelData.isEmpty()) {
            actualExcelData = ExcelUtil.
                    getExcelRowDataAsMapList(
                            FrameworkConstants.getRunmanagerpath()
                            ,FrameworkConstants.getTestdatasheet());
        }
        List<Map<String, String>> requiredExceldata = new ArrayList<>();

        for (Map<String, String> actualExcelDatum : actualExcelData) {
            if ((actualExcelDatum.get("TestName").equalsIgnoreCase(testName)) &&
                    (actualExcelDatum.get("Execute").equalsIgnoreCase("YES"))) {
                requiredExceldata.add(actualExcelDatum);
            }
        }

        Object[][] requiredExcelDataAsObjArray = new Object[requiredExceldata.size()][2];
        for (int index = 0; index < requiredExceldata.size(); index++) {
            requiredExcelDataAsObjArray[index][0] = index;
            requiredExcelDataAsObjArray[index][1] = requiredExceldata.get(index);

        }


        return requiredExcelDataAsObjArray;
    }
}
