package org.mln.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
     static final int MAXRETRY = 1;
    int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        boolean value = retryCount <= MAXRETRY;
        retryCount++;
        return value;
    }

}

