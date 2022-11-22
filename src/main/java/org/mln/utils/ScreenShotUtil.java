package org.mln.utils;

import org.mln.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * It takes a screenshot of the current page and returns it as a base64 string
 */
public final class ScreenShotUtil {

    private ScreenShotUtil(){
    }

    /**
     * It takes a screenshot of the current page, and returns it as a base64 string
     *
     * @return A string of the base64 image.
     */
    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
