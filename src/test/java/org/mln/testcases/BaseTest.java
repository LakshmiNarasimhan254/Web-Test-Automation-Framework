package org.mln.testcases;

import org.mln.driver.Driver;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class BaseTest {
    protected BaseTest() {}


    @BeforeMethod
    public void setUp(Object[] data,Method method) throws Exception {
       Map<String,String> dataMap = (Map<String, String>) data[1];
        System.out.println(dataMap.get("Browser"));
       Driver.initDriver(dataMap.get("Browser"));
    }
    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
