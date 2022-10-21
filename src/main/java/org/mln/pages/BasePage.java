package org.mln.pages;

import org.mln.constants.FrameworkConstants;
import org.mln.driver.DriverManager;
import org.mln.enums.WaitConditions;
import org.mln.factory.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class BasePage {

    WebElement webElement = null;
    protected void click(By by, WaitConditions waitConditions) {

        webElement= ExplicitWaitFactory.waitForElement(waitConditions,by);
        webElement.sendKeys(Keys.ENTER);
        //DriverManager.getDriver().findElement(by).sendKeys();
    }

    protected void enterText(By by, String txtValue, WaitConditions waitConditions) {
        webElement= ExplicitWaitFactory.waitForElement(waitConditions,by);
        webElement.clear();
        webElement.sendKeys(txtValue);
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }




}
