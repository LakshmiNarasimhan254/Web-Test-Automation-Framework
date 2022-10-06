package org.mln.constants;



public final class FrameworkConstants {
    private  static final String TESTRESOURCEPATH=System.getProperty("user.dir") +"/src/test/resources/";
    private static final String CHROMEDRIVERPATH = TESTRESOURCEPATH + "executables/chromedriver.exe";
    private static final String CONFIGPATH = TESTRESOURCEPATH + "config/config.properties";
    //private constructor will prevent in creating an object for this class
    private FrameworkConstants(){}

    //getter method
    public static String getChromedriverPath(){
        return  CHROMEDRIVERPATH;
    }
    public static String getConfigPath(){
        return  CONFIGPATH;
    }

}
