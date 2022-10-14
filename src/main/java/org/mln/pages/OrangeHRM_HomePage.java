package org.mln.pages;

import org.mln.driver.DriverManager;
import org.openqa.selenium.By;

public class OrangeHRM_HomePage {
    private  final By link_welcome = By.xpath("//p[@class ='oxd-userdropdown-name']");
    private  final By link_logout = By.xpath("//a[text()='Logout']");

    public OrangeHRM_HomePage clickWelcome(){
        DriverManager.getDriver().findElement(link_welcome).click();
        return this;
    }

    public OrangeHRM_LoginPage clickLogout(){
        DriverManager.getDriver().findElement(link_logout).click();
        return new OrangeHRM_LoginPage();
    }

    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
