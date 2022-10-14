package org.mln.testcases;

import org.mln.driver.Driver;
import org.mln.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected BaseTest() {
           }


    @BeforeSuite
    public void setUp() throws Exception {
        Driver.initDriver();
    }
    @AfterSuite
    public void tearDown() {
        Driver.quitDriver();
    }


}
