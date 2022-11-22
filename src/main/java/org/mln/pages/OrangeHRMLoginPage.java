package org.mln.pages;

import org.mln.enums.WaitConditions;
import org.mln.utils.DecodeUtil;
import org.openqa.selenium.By;

/**
 * It's a page object class that represents the login page of the OrangeHRM application
 */
public class OrangeHRMLoginPage extends BasePage{

    private final By textboxusername = By.name("username");
    private final By textboxpassword = By.xpath("//input[@name=\'password\' and @type=\'password\']");
    private final By buttonlogin = By.xpath("//button[text()=\' Login \' and @type=\'submit\']");

    /**
     * This function enters the user name in the user name text box
     *
     * @param userName The value that you want to enter in the textbox
     * @return The page object itself.
     */
    public OrangeHRMLoginPage enterUserName(String userName) {
        enterText(textboxusername,userName ,WaitConditions.VISIBLE,"UserName");
        return this;
    }

    /**
     * This function takes a string as input, decodes it using the base64Decode function from the DecodeUtil class, and
     * enters it into the password textbox
     *
     * @param passWord The password to be entered in the password textbox.
     * @return The page object itself.
     */
    public OrangeHRMLoginPage enterPassword(String passWord)  {
        enterText(textboxpassword, DecodeUtil.base64Decode(passWord),WaitConditions.VISIBLE,"Password");
        return this;
    }

    /**
     * The function clicks on the login button and returns the OrangeHRMHomePage object
     *
     * @return OrangeHRMHomePage
     */
    public final  OrangeHRMHomePage clickLogin()  {
        click(buttonlogin, WaitConditions.CLICKABLE,"Login Button");

        return new OrangeHRMHomePage();
    }

    /**
     * The function `getTitle()` returns the title of the current page
     *
     * @return The title of the page.
     */
    public String getTitle(){
        return getPageTitle();
    }

}
