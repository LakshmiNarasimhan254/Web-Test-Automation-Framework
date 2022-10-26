package org.mln.driver;

import org.mln.constants.FrameworkConstants;
import org.mln.enums.ConfigProperties;
import org.mln.util.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Driver {


    private Driver(){
    }
    private static WebDriver driver;
    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverPath());
            driver = new ChromeDriver();
            DriverManager.setDriver(driver);
           //    DriverManager.getDriver().manage().window().maximize();
          //  DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            DriverManager.getDriver().get(PropertyUtil.getValue(ConfigProperties.URL));
        }
    }
    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unLoad();
        }
    }
}
