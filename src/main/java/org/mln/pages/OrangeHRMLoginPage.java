package org.mln.pages;

import org.mln.driver.DriverManager;
import org.mln.enums.WaitConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMLoginPage extends BasePage{

    private final By textboxusername = By.name("username");
    private final By textboxpassword = By.xpath("//input[@name='password' and @type='password']");
    private final By buttonlogin = By.xpath("//button[text()=' Login ' and @type='submit']");

    public OrangeHRMLoginPage enterUserName(String userName){
        enterText(textboxusername,userName ,WaitConditions.VISIBLE);
         return this;
    }

    public OrangeHRMLoginPage enterPassword(String passWord){
        enterText(textboxpassword,passWord,WaitConditions.VISIBLE);
        return this;
    }

    public final  OrangeHRMHomePage clickLogin(){
        click(buttonlogin, WaitConditions.CLICKABLE);
        return new OrangeHRMHomePage();
    }

    public String getTitle(){
        return getPageTitle();
    }

}
