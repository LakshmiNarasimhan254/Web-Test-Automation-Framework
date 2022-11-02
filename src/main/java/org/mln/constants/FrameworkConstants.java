package org.mln.constants;


import org.mln.enums.ConfigProperties;
import org.mln.util.PropertyUtil;

public final class FrameworkConstants {
    private static final String TESTRESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String CHROMEDRIVERPATH = TESTRESOURCEPATH + "executables/chromedriver.exe";
    private static final String CONFIGPATH = TESTRESOURCEPATH + "config/config.properties";
    private static final int EXPLICITWAITTIME = 10;
    private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/extent-reports/";

    //private constructor will prevent in creating an object for this class
    private FrameworkConstants() {
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

    public static String getExtentreportpath() throws Exception {
        if (PropertyUtil.getValue(ConfigProperties.OVERRIDEDYNAMICREPORT).equalsIgnoreCase("yes")) {
            return EXTENTREPORTPATH + "index" + System.currentTimeMillis() + ".html";
        } else {
            return EXTENTREPORTPATH + "index.html";
        }

    }

}
