package org.mln.driver;

import org.mln.constants.FrameworkConstants;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver {


    private Driver(){
    }
    private static WebDriver driver;
    public static void initDriver(String browser) throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            if(browser.equalsIgnoreCase("CHROME")) {
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverPath());
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("FIREFOX")) {
                System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckodriverpath());
                driver = new FirefoxDriver();
            }

            DriverManager.setDriver(driver);
              // DriverManager.getDriver().manage().window().maximize();
             // DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
