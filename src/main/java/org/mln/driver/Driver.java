package org.mln.driver;

import org.mln.customexceptions.BrowserInvocationFailedException;
import org.mln.customexceptions.CustomException;
import org.mln.enums.ConfigProperties;
import org.mln.factory.DriverFactory;
import org.mln.utils.PropertyUtil;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;


/**
 * The Driver class is a utility class that initializes the WebDriver instance and quits the WebDriver instance
 */
public final class Driver {


    private Driver() {
    }




    /**
     * If the driver is not null, then set the driver to the browser specified in the parameter
     *
     * @param browser
     *         The browser to be used for the test.
     */
    public static void initDriver(String browser,String version) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser,version));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException(e.getCause());
            } catch (IOException e) {
                throw new CustomException(e.getMessage());
            }catch (Exception e) {
                throw new CustomException((e.getMessage()));
            }
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertyUtil.getValue(ConfigProperties.URL));
        }
    }

    /**
     * If the driver is not null, then quit the driver and unload it
     */
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unLoad();
        }
    }
}
