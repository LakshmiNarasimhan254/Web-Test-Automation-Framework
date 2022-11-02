package org.mln.testcases;

import org.mln.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


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
