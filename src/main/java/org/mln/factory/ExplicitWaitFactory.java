package org.mln.factory;

import org.mln.constants.FrameworkConstants;
import org.mln.driver.DriverManager;
import org.mln.enums.WaitConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to wait for an element to be clickable, present, visible or none
 */
public class ExplicitWaitFactory {

    private ExplicitWaitFactory(){
    }

    /**
     * It waits for the element to be clickable, present, visible or none (no wait) based on the wait condition passed as a
     * parameter
     *
     * @param waitConditions This is an enum that has the following values:
     * @param by The locator of the element.
     * @return WebElement
     */
    public static WebElement waitForElement(WaitConditions waitConditions, By by) {
        WebElement webElement =null;
        if (waitConditions.toString().equalsIgnoreCase("CLICKABLE")) {
           webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getEXPLICITWAITTIME())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitConditions.toString().equalsIgnoreCase("PRESENT")) {
            webElement=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getEXPLICITWAITTIME())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitConditions.toString().equalsIgnoreCase("VISIBLE")) {
            webElement= new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getEXPLICITWAITTIME())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitConditions.toString().equalsIgnoreCase("NONE")) {
            webElement =DriverManager.getDriver().findElement(by);
        }
        return webElement;
    }
}
