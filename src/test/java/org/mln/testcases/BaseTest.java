package org.mln.testcases;

import org.mln.driver.Driver;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * The `BaseTest` class is a base class for all of our test classes. It contains the `@BeforeMethod` and `@AfterMethod`
 * annotations. The `@BeforeMethod` annotation is used to run code before each test method. The `@AfterMethod` annotation
 * is used to run code after each test method
 */
public class BaseTest {
    protected BaseTest() {}


    /**
     * A BeforeMethod annotation that runs before each test method. It takes two parameters:
     * 1. Object[] data - This is the data that is passed from the DataProvider.
     * 2. Method method - This is the method that is being run.
     *
     * @param data This is the data that is passed from the data provider.
     * @param method The method that is being executed.
     */
    @BeforeMethod
    public void setUp(Object[] data,Method method) {
       Map<String,String> dataMap = (Map<String, String>) data[1];
       Driver.initDriver(dataMap.get("Browser"), dataMap.get("Version"));
    }
    /**
     * It closes the browser after each test.
     */
    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
