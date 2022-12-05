package org.mln.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

/**
 * This class is used to create a driver object based on the browser type and runmode
 */
public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver(String browser,String version) throws Exception{
        WebDriver webDriver =null;
        if (browser.equalsIgnoreCase(BrowserType.CHROME)) {
            if (PropertyUtil.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(BrowserType.CHROME);
                desiredCapabilities.setVersion(version);
                    webDriver = new RemoteWebDriver(new URL(PropertyUtil.getValue(ConfigProperties.GRIDURL)), desiredCapabilities);
            } else {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase(BrowserType.FIREFOX)) {
            if (PropertyUtil.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
                desiredCapabilities.setVersion(version);
                    webDriver = new RemoteWebDriver(new URL(PropertyUtil.getValue(ConfigProperties.GRIDURL)), desiredCapabilities);

            } else {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
        }else if (browser.equalsIgnoreCase(BrowserType.EDGE)) {
            if (PropertyUtil.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(BrowserType.EDGE);
                desiredCapabilities.setVersion(version);
                webDriver = new RemoteWebDriver(new URL(PropertyUtil.getValue(ConfigProperties.GRIDURL)) , desiredCapabilities);

            } else {
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
            }
        }

        return webDriver;
    }
}
