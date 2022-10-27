package org.mln.reports;

public class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String loggerText){
        ExtentReportManager.getExtentTest().pass(loggerText);
    }
    public static void fail(String loggerText){
        ExtentReportManager.getExtentTest().fail(loggerText);
    }
    public static void skip(String loggerText){
        ExtentReportManager.getExtentTest().skip(loggerText);
    }
}
