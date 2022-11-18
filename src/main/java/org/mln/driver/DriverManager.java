package org.mln.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {


    private DriverManager() {
    }

    private final static ThreadLocal<WebDriver>tl = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return tl.get();
    }
    public static void setDriver(WebDriver driverRef){
        tl.set(driverRef);
    }
    public static void unLoad(){
        tl.remove();
    }
}
