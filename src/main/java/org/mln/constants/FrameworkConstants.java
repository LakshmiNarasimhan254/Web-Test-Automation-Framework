package org.mln.constants;


import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;

public final class FrameworkConstants {
    private static final String TESTRESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String CHROMEDRIVERPATH = TESTRESOURCEPATH + "executables/chromedriver.exe";
    private static final String GECKODRIVERPATH = TESTRESOURCEPATH + "executables/geckodriver.exe";
    private static final String CONFIGPATH = TESTRESOURCEPATH + "config/config.properties";
    private static final int EXPLICITWAITTIME = 10;
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-reports/";

    private static final String EXCELPATH = TESTRESOURCEPATH+"excel/";
    private static final String RUNMANAGERPATH =EXCELPATH +"TestInput.xlsx";
    private static final String RUNMANAGERSHEET = "RunManager";
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


    //getter method
    public static String getTestResourcePath() {
        return TESTRESOURCEPATH;
    }
    public static String getChromedriverPath() { return CHROMEDRIVERPATH;}
    public static String getGeckodriverpath() { return GECKODRIVERPATH; }
    public static String getConfigPath() {
        return CONFIGPATH;
    }
    public static int getExplicitwaittime() {
        return EXPLICITWAITTIME;
    }
    public static String getExcelpath(){return EXCELPATH;}
    public static String getRunmanagerpath(){return RUNMANAGERPATH;}
    public static String getRunmanagersheet(){return RUNMANAGERSHEET;}
    public static String getTestdatasheet(){return TESTDATASHEET;}
}



