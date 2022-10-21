package org.mln.factory;

import org.mln.constants.FrameworkConstants;
import org.mln.driver.DriverManager;
import org.mln.enums.WaitConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitFactory {

    private ExplicitWaitFactory(){
    }

    public static WebElement waitForElement(WaitConditions waitConditions, By by) {
        WebElement webElement =null;
        if (waitConditions.toString().equalsIgnoreCase("CLICKABLE")) {
           webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwaittime())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitConditions.toString().equalsIgnoreCase("PRESENT")) {
            webElement=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwaittime())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitConditions.toString().equalsIgnoreCase("VISIBLE")) {
            webElement= new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwaittime())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitConditions.toString().equalsIgnoreCase("NONE")) {
            webElement =DriverManager.getDriver().findElement(by);
        }
        return webElement;
    }
}
