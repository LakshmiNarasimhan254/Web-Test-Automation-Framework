package org.mln.listeners;


import org.mln.factory.datafactory.ExcelDataProvider;
import org.testng.annotations.ITestAnnotation;
import org.testng.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
       iTestAnnotation.setDataProvider("getExcelData");
       iTestAnnotation.setDataProviderClass(ExcelDataProvider.class);
       iTestAnnotation.setRetryAnalyzer(RetryFailedTests.class);
    }
}
