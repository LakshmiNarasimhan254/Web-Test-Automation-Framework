package org.mln.testcases;

import org.mln.driver.Driver;
import org.mln.driver.DriverManager;
import org.mln.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {
    protected BaseTest() {}


    @BeforeMethod
    public void setUp(Method method) throws Exception {
        Driver.initDriver();
    }
    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
