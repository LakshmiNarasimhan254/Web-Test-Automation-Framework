package org.mln.pages;

import org.mln.driver.DriverManager;
import org.openqa.selenium.By;

public class OrangeHRMHomePage {
    private  final By linkwelcome = By.xpath("//p[@class ='oxd-userdropdown-name']");
    private  final By linklogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome(){
        DriverManager.getDriver().findElement(linkwelcome).click();
        return this;
    }

    public OrangeHRMLoginPage clickLogout(){
        DriverManager.getDriver().findElement(linklogout).click();
        return new OrangeHRMLoginPage();
    }

    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
