package org.mln.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.mln.utils.ScreenShotUtil;

public class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String loggerText) throws Exception {
        if (PropertyUtil.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("YES")) {

            ExtentReportManager.getExtentTest()
                    .pass(loggerText,
                            MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
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
                            MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
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
                            MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
        }
        else{
            ExtentReportManager.getExtentTest()
                    .skip(loggerText);
        }
    }



}
