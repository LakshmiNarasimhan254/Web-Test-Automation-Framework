package org.mln.reports;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.mln.constants.FrameworkConstants;
import org.mln.enums.ConfigProperties;
import org.mln.util.PropertyUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport(){
    }
    private static ExtentReports extentReports;

    public static void initReports() throws Exception {
        if(Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentreportpath());
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setReportName(PropertyUtil.getValue(ConfigProperties.APPNAME));
            extentSparkReporter.config().setDocumentTitle("Automation-Report");
        }
    }

    public static void flushReports() throws Exception {
        if(Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
           Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportpath()).toURI());
    }
    public static void createTest(String testcaseName){
          ExtentReportManager.setExtentTest(extentReports.createTest(testcaseName));

    }
}
