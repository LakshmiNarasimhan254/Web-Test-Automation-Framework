package org.mln.pages;

import org.mln.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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

    public OrangeHRM_HomePage clickLogin(){
        DriverManager.getDriver().findElement(button_login).sendKeys(Keys.ENTER);
        return new OrangeHRM_HomePage();
    }

}
