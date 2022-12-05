package org.mln.constants;


import lombok.Getter;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;

/**
 * This class contains all the constants that are used in the framework
 */
public final class FrameworkConstants {
   @Getter
    private static final String TESTRESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources/";
    // private static final String CHROMEDRIVERPATH = TESTRESOURCEPATH + "executables/chromedriver.exe";
     //private static final String GECKODRIVERPATH = TESTRESOURCEPATH + "executables/geckodriver.exe";
   @Getter
    private static final String CONFIGPATH = TESTRESOURCEPATH + "config/config.properties";
    @Getter
    private static final int EXPLICITWAITTIME = 10;
    @Getter
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-reports/";

    @Getter
    private static final String EXCELPATH = TESTRESOURCEPATH+"excel/";
    @Getter
    private static final String RUNMANAGERPATH =EXCELPATH +"TestInput.xlsx";
    @Getter
    private static final String RUNMANAGERSHEET = "RunManager";
    @Getter
    private static final String TESTDATASHEET = "TestData";

    private static String extenReportFilePath = "";

    //private constructor will prevent in creating an object for this class
    private FrameworkConstants() {
    }

    public static String getExtenReportFilePath() {
        if (PropertyUtil.getValue(ConfigProperties.OVERRIDEDYNAMICREPORT).equalsIgnoreCase("no")) {
            if (extenReportFilePath.isEmpty()) {
                extenReportFilePath = EXTENTREPORTFOLDERPATH + "index" + System.currentTimeMillis() + ".html";
            }

        } else {
            extenReportFilePath = EXTENTREPORTFOLDERPATH + "index.html";
        }
        return extenReportFilePath;
    }


}



