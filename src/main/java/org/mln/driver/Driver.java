package org.mln.driver;

import org.mln.constants.FrameworkConstants;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;


/**
 * The Driver class is a utility class that initializes the WebDriver instance and quits the WebDriver instance
 */
public final class Driver {


    private Driver(){
    }
    private static WebDriver webDriver;



    /**
     * If the driver is not null, then set the driver to the browser specified in the parameter
     *
     * @param browser The browser to be used for the test.
     */
    public static void initDriver(String browser){
        if (Objects.isNull(DriverManager.getDriver())) {
            if(browser.equalsIgnoreCase("CHROME")) {
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverPath());
                webDriver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("FIREFOX")) {
                System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckodriverpath());
                webDriver = new FirefoxDriver();
            }

            DriverManager.setDriver(webDriver);
                DriverManager.getDriver().manage().window().maximize();
                DriverManager.getDriver().get(PropertyUtil.getValue(ConfigProperties.URL));

        }
    }
    /**
     * If the driver is not null, then quit the driver and unload it
     */
    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unLoad();
        }
    }
}
