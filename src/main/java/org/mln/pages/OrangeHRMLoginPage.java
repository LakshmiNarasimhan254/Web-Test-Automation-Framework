package org.mln.pages;

import org.mln.enums.WaitConditions;
import org.openqa.selenium.By;

public class OrangeHRMLoginPage extends BasePage{

    private final By textboxusername = By.name("username");
    private final By textboxpassword = By.xpath("//input[@name='password' and @type='password']");
    private final By buttonlogin = By.xpath("//button[text()=' Login ' and @type='submit']");

    public OrangeHRMLoginPage enterUserName(String userName) throws Exception {
        enterText(textboxusername,userName ,WaitConditions.VISIBLE,"UserName");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String passWord) throws Exception {
        enterText(textboxpassword,passWord,WaitConditions.VISIBLE,"Password");
        return this;
    }

    public final  OrangeHRMHomePage clickLogin() throws Exception {
        click(buttonlogin, WaitConditions.CLICKABLE,"Login Button");

        return new OrangeHRMHomePage();
    }

    public String getTitle(){
        return getPageTitle();
    }

}
