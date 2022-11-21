package org.mln.listeners;


import org.mln.annotations.TestInfo;
import org.mln.reports.ExtentLogger;
import org.mln.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;

public class Listener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }


    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }


    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addAuthor(result
                                .getMethod()
                                .getConstructorOrMethod()
                                .getMethod()
                                .getAnnotation(TestInfo.class)
                                .author());

        ExtentReport.addCategory(result
                .getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(TestInfo.class)
                .categories());
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is  Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is  Failed");
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is  Skipped");
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
