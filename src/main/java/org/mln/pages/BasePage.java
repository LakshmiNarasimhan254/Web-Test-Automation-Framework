package org.mln.pages;


import org.mln.driver.DriverManager;
import org.mln.enums.WaitConditions;
import org.mln.factory.ExplicitWaitFactory;
import org.mln.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * This class contains all the common methods that are used in the test scripts
 */
public class BasePage {

    WebElement webElement = null;
    /**
     * This function is used to click on a web element
     *
     * @param by The locator of the element
     * @param waitConditions This is an enum which contains the different wait conditions that can be used.
     * @param elementName This is the name of the element that you want to click.
     */
    protected void click(By by, WaitConditions waitConditions,String elementName) {

        webElement= ExplicitWaitFactory.waitForElement(waitConditions,by);
        webElement.click();
        ExtentLogger.pass(elementName +" is clicked successfully");

    }

    /**
     * This function will wait for the element to be visible and then enter the text in the text box
     *
     * @param by The locator of the element
     * @param txtValue The text that you want to enter in the text box.
     * @param waitConditions This is an enum that contains the different wait conditions that can be used.
     * @param elementName This is the name of the element that you want to enter text into.
     */
    protected void enterText(By by, String txtValue, WaitConditions waitConditions,String elementName) {
        webElement= ExplicitWaitFactory.waitForElement(waitConditions,by);
        webElement.clear();
        webElement.sendKeys(txtValue);
        ExtentLogger.pass(txtValue +" entered successfully in  " + elementName);

    }

    /**
     * > This function returns the title of the current page
     *
     * @return The title of the page.
     */
    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


    /**
     * This function returns a boolean value that is true if the element is displayed and false if the element is not
     * displayed.
     *
     * @param xpath The xpath of the element you want to check if it's displayed.
     * @return A boolean value.
     */
    protected boolean isElementDisplayed(String xpath){
        return DriverManager.getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

}
