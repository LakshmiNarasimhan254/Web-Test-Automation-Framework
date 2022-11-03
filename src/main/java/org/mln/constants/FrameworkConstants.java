package org.mln.constants;


import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;

public final class FrameworkConstants {
    private static final String TESTRESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String CHROMEDRIVERPATH = TESTRESOURCEPATH + "executables/chromedriver.exe";
    private static final String CONFIGPATH = TESTRESOURCEPATH + "config/config.properties";
    private static final int EXPLICITWAITTIME = 10;
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-reports/";
    private static String extenReportFilePath = "";

    //private constructor will prevent in creating an object for this class
    private FrameworkConstants() {
    }

    public static String getExtenReportFilePath() throws Exception {
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

    public static String getChromedriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getConfigPath() {
        return CONFIGPATH;
    }

    public static int getExplicitwaittime() {
        return EXPLICITWAITTIME;
    }
}



