package org.mln.listeners;

import lombok.SneakyThrows;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    int maxRetry = 1;
    int retryCount = 0;

    @SneakyThrows
    @Override
    public boolean retry(ITestResult result) {
        boolean value =false;
        if (PropertyUtil.getValue(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("YES")) {
            value = retryCount < maxRetry;

                retryCount++;


        }
        return value;
    }

}

