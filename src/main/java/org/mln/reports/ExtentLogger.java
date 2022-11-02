package org.mln.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.mln.driver.DriverManager;
import org.mln.enums.ConfigProperties;
import org.mln.util.PropertyUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String loggerText) throws Exception {
        if (PropertyUtil.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("YES")) {
            System.out.println(PropertyUtil.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOT));
            ExtentReportManager.getExtentTest()
                    .pass(loggerText,
                            MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
        else{
            ExtentReportManager.getExtentTest()
                    .pass(loggerText);
        }
    }

    public static void fail(String loggerText) throws Exception {
        if (PropertyUtil.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("YES")) {
            ExtentReportManager.getExtentTest()
                    .fail(loggerText,
                            MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
        else{
            ExtentReportManager.getExtentTest()
                    .fail(loggerText);
        }
    }

    public static void skip(String loggerText) throws Exception {
        if (PropertyUtil.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("YES")) {
            ExtentReportManager.getExtentTest()
                    .skip(loggerText,
                            MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
        else{
            ExtentReportManager.getExtentTest()
                    .skip(loggerText);
        }
    }

    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}
