package org.mln.pages;

import org.mln.driver.DriverManager;
import org.mln.enums.WaitConditions;;

import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {
    private  final By linkwelcome = By.xpath("//i[@class ='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private  final By linklogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome() throws Exception {
        click(linkwelcome, WaitConditions.PRESENT,"Welcome Link");
        return this;
    }

    public OrangeHRMLoginPage clickLogout() throws Exception {
        click(linklogout, WaitConditions.CLICKABLE,"LogOut button");
        return new OrangeHRMLoginPage();
    }

    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
