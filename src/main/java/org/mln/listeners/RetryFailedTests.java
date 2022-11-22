package org.mln.listeners;

import lombok.SneakyThrows;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class implements the IRetryAnalyzer interface and overrides the retry() method.
 *
 * The retry() method returns true if the test method has to be retried and false it not.
 *
 * The retryCount variable is used to keep track of how many times a test has been run.
 *
 * The maxRetry variable is used to set the maximum number of times the test should be rerun.
 *
 * The retry() method is called every time a test fails.
 *
 * If the test has failed maxRetry number of times, the test will be marked as failed.
 *
 * If the test has not failed maxRetry number of times, the test will be marked as failed and will be rerun.
 *
 * The retryCount variable is incremented every time the test fails.
 *
 * The retry() method is called by TestNG after the test fails.
 *
 *
 *
 *
 * */
public class RetryFailedTests implements IRetryAnalyzer {
    int maxRetry = 1;
    int retryCount = 0;


    @Override
    // A method that is called when a test fails. It returns true if the test should be retried.
    public boolean retry(ITestResult result) {
        boolean value =false;
        if (PropertyUtil.getValue(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("YES")) {
            value = retryCount < maxRetry;

                retryCount++;


        }
        return value;
    }

}

