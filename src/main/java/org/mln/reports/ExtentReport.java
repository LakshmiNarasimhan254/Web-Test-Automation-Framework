package org.mln.reports;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.mln.constants.FrameworkConstants;
import org.mln.customexceptions.CustomException;
import org.mln.customexceptions.FileIOException;
import org.mln.customexceptions.InvalidPathForFileException;
import org.mln.enums.Categories;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport(){
    }
    private static ExtentReports extentReports;

    public static void initReports()  {
        if(Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtenReportFilePath());
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setReportName(PropertyUtil.getValue(ConfigProperties.APPNAME));
            extentSparkReporter.config().setDocumentTitle("Automation-Report");
        }
    }

    public static void flushReports() {
        if(Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
           ExtentReportManager.unLoad();

        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtenReportFilePath()).toURI());
        } catch (IOException e) {
            // Did not handle using try catch because , don't want to stop the program because it is just opening the report
            e.printStackTrace();
        }


    }
    public static void createTest(String testcaseName){
          ExtentReportManager.setExtentTest(extentReports.createTest(testcaseName));

    }

    public static void addAuthor(String[] authors){
        for(String author:authors){
            ExtentReportManager.getExtentTest().assignAuthor(author);
        }
    }
    public static void addCategory(Categories[] categories){
        for(Enum<Categories> category:categories){
            ExtentReportManager.getExtentTest().assignCategory(String.valueOf(category));
        }
    }
}
