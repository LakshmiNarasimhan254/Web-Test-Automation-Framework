package org.mln.pages;


import org.mln.driver.DriverManager;
import org.mln.enums.WaitConditions;
import org.mln.factory.ExplicitWaitFactory;
import org.mln.reports.ExtentLogger;
import org.mln.utils.DynamicXPathUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {

    WebElement webElement = null;
    protected void click(By by, WaitConditions waitConditions,String elementName) throws Exception {

        webElement= ExplicitWaitFactory.waitForElement(waitConditions,by);
        webElement.click();
        ExtentLogger.pass(elementName +" is clicked successfully");

    }

    protected void enterText(By by, String txtValue, WaitConditions waitConditions,String elementName) throws Exception {
        webElement= ExplicitWaitFactory.waitForElement(waitConditions,by);
        webElement.clear();
        webElement.sendKeys(txtValue);
        ExtentLogger.pass(txtValue +" entered successfully in  " + elementName);

    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


    protected boolean isElementDisplayed(String xpath){
        return DriverManager.getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

}
