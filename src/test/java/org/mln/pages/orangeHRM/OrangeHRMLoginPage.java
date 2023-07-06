package org.mln.pages.orangeHRM;

import org.mln.enums.WaitConditions;
import org.mln.pages.BasePage;
import org.mln.utils.DecodeUtil;
import org.openqa.selenium.By;

/**
 * It's a page object class that represents the login page of the OrangeHRM application
 */
public class OrangeHRMLoginPage extends BasePage {

    private final By txtbxusername = By.name("username");
    private final By txtbxpassword = By.xpath("//input[@name=\'password\' and @type=\'password\']");
    private final By btnlogin = By.xpath("//button[text()=\' Login \' and @type=\'submit\']");

    /**
     * This function enters the user name in the user name text box
     *
     * @param userName The value that you want to enter in the textbox
     * @return The page object itself.
     */
    public OrangeHRMLoginPage enterUserName(String userName) {
        seleniumeInteractionsUtil.enterText(txtbxusername,userName ,WaitConditions.VISIBLE,"UserName");
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
        seleniumeInteractionsUtil.enterText(txtbxpassword, DecodeUtil.base64Decode(passWord),WaitConditions.VISIBLE,"Password");
        return this;
    }

    /**
     * The function clicks on the login button and returns the OrangeHRMHomePage object
     *
     * @return OrangeHRMHomePage
     */
    public final OrangeHRMHomePage clickLogin()  {
        seleniumeInteractionsUtil.click(btnlogin, WaitConditions.CLICKABLE,"Login Button");

        return new OrangeHRMHomePage();
    }

    /**
     * The function `getTitle()` returns the title of the current page
     *
     * @return The title of the page.
     */
    public String getTitle(){
        return seleniumeInteractionsUtil.getPageTitle();
    }

}
