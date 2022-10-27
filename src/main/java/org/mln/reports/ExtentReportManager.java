package org.mln.reports;


import com.aventstack.extentreports.ExtentTest;


public class ExtentReportManager {
    private ExtentReportManager(){}
    private static ThreadLocal<ExtentTest>tl = new ThreadLocal<>();

    static ExtentTest getExtentTest(){//Made it to Defaul access specifier so that it is private to package
        return tl.get();
    }
    static void setExtentTest(ExtentTest extentTest){
        tl.set(extentTest);
    }
    static void unLoad(){
        tl.remove();
    }
}
