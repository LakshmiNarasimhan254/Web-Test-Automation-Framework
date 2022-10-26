package org.mln.reports;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport(){
    }
    private static ExtentReports extentReports;

    public static void initReports(){
        if(Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("index.html");
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setReportName("OrangeHRM Test");
            extentSparkReporter.config().setDocumentTitle("Automation Report");
        }
    }

    public static void flushReports() throws IOException {
        if(Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
           Desktop.getDesktop().browse(new File("index.html").toURI());
    }
    public static void createTest(String testcaseName){
          ExtentReportManager.setExtentTest(extentReports.createTest(testcaseName));

    }
}
