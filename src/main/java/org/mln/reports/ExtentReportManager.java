package org.mln.reports;


import com.aventstack.extentreports.ExtentTest;


public class ExtentReportManager {
    private ExtentReportManager(){}
    private static ThreadLocal<ExtentTest>tl = new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
        return tl.get();
    }
    public static void setExtentTest(ExtentTest extentTest){
        tl.set(extentTest);
    }
    public static void unLoad(){
        tl.remove();
    }
}
