package org.mln.testcases;

import org.mln.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected BaseTest() {
           }


    @BeforeMethod
    public void setUp() throws Exception {
        Driver.initDriver();
    }
    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();

    }
}
