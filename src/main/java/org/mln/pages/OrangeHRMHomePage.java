package org.mln.pages;

import org.mln.driver.DriverManager;
import org.mln.enums.WaitConditions;;

import org.openqa.selenium.By;

/**
 * This class is a page object class for the OrangeHRM Home Page. It contains methods to click on the Welcome link and the
 * Logout link
 */
public final class OrangeHRMHomePage extends BasePage {
    private  final By linkwelcome = By.xpath("//i[@class =\'oxd-icon bi-caret-down-fill oxd-userdropdown-icon\']");
    private  final By linklogout = By.xpath("//a[text()=\'Logout\']");

    /**
     * Click the welcome link on the home page
     *
     * @return The page object itself.
     */
    public OrangeHRMHomePage clickWelcome() {
        click(linkwelcome, WaitConditions.PRESENT,"Welcome Link");
        return this;
    }

    /**
     * This function clicks on the logout button and returns the login page
     *
     * @return The OrangeHRMLoginPage class is being returned.
     */
    public OrangeHRMLoginPage clickLogout() {
        click(linklogout, WaitConditions.CLICKABLE,"LogOut button");
        return new OrangeHRMLoginPage();
    }

    /**
     * Get the title of the current page.
     *
     * @return The title of the page
     */
    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
