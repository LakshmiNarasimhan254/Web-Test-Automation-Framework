package org.mln.listeners;

import lombok.SneakyThrows;

import org.mln.reports.ExtentLogger;
import org.mln.reports.ExtentReport;
import org.testng.*;

public class Listener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @SneakyThrows
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @SneakyThrows
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName()+ " is  Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName()+ " is  Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName()+ " is  Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        //No operation for now
    }

    @Override
    public void onStart(ITestContext context) {
        //No operation for now
    }

    @Override
    public void onFinish(ITestContext context) {
        //No operation for now

    }
}
