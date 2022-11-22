package org.mln.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.mln.enums.BrowserTypes;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class is used to create a driver object based on the browser type and runmode
 */
public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        WebDriver webDriver =null;
        if (browser.equalsIgnoreCase(BrowserTypes.CHROME.toString())) {
            //System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverPath());

            if (PropertyUtil.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(BrowserTypes.CHROME.toString());

                    webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hun"), desiredCapabilities);

            } else {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase(BrowserTypes.FIREFOX.toString())) {
            //System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckodriverpath());


            if (PropertyUtil.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(BrowserTypes.FIREFOX.toString());

                    webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hun"), desiredCapabilities);

            } else {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
        }
        return webDriver;
    }
}
