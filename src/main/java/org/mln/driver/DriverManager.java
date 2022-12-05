package org.mln.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

/**
 * The DriverManager class is a singleton class that provides a single point of access to the WebDriver instance
 */
public final class DriverManager {


    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver>tl = new ThreadLocal<>();

    /**
     * It returns the driver instance that is stored in the ThreadLocal variable
     *
     * @return The driver that is being used by the current thread.
     */
    public static WebDriver getDriver(){
        return tl.get();
    }
    /**
     * The function takes a WebDriver object as a parameter and sets it to the ThreadLocal object
     *
     * @param driverRef This is the WebDriver object that you want to set.
     */
    static void setDriver(WebDriver driverRef){
        if (Objects.nonNull(driverRef)){
            tl.set(driverRef);
        }

    }
    /**
     * The function removes the current thread from the thread local variable
     */
    static void unLoad(){
        tl.remove();
    }
}
