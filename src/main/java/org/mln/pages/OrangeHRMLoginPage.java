package org.mln.pages;

import org.mln.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM_LoginPage {

    private final By textbox_username = By.name("username");
    private final By textbox_password = By.xpath("//input[@name='password' and @type='password']");
    private final By button_login = By.xpath("//button[text()=' Login ' and @type='submit']");

    public OrangeHRM_LoginPage enterUserName(String userName){
        DriverManager.getDriver().findElement(textbox_username).clear();
        DriverManager.getDriver().findElement(textbox_username).sendKeys(userName);
        return this;
    }

    public OrangeHRM_LoginPage enterPassword(String passWord){
        DriverManager.getDriver().findElement(textbox_password).clear();
        DriverManager.getDriver().findElement(textbox_password).sendKeys(passWord);
        return this;
    }

    public OrangeHRMHomePage clickLogin(){
        new WebDriverWait(DriverManager.getDriver(),10)
        .until(ExpectedConditions.elementToBeClickable(button_login));
        DriverManager.getDriver().findElement(button_login).sendKeys(Keys.ENTER);
        return new OrangeHRMHomePage();
    }

    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }

}
