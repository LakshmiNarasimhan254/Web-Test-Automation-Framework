package org.mln.testcases.orangeHRM;


import org.assertj.core.api.Assertions;
import org.mln.pages.orangeHRM.OrangeHRMHomePage;
import org.mln.pages.orangeHRM.OrangeHRMLoginPage;
import org.mln.testcases.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;


/**
 * This class is a test class that extends the BaseTest class. It has two test methods, login and logout. The login method
 * is a test method that takes two parameters, runCount and testdata. The login method calls the login method of the
 * OrangeHRMLoginPage class and then calls the getTitle method of the OrangeHRMHomePage class. The logout method is a test
 * method that calls the logout method of the OrangeHRMHomePage class and then calls the getTitle method of the
 * OrangeHRMHomePage class
 */
public final class LoginPageTest extends BaseTest {
    OrangeHRMLoginPage orangeHRMloginPage = new OrangeHRMLoginPage();
    OrangeHRMHomePage orangeHRMhomePage;

    private LoginPageTest() {
    }

    @Test
    // This is a test method that takes two parameters, runCount and testdata.
    // The login method calls the login method of the
    // OrangeHRMLoginPage class and then calls the getTitle method of the OrangeHRMHomePage class.
    public void login(Integer runCount, HashMap<String, String> testdata) throws Exception {


        orangeHRMhomePage = orangeHRMloginPage
                .enterUserName(testdata.get("UserName"))
                .enterPassword(testdata.get("Password"))
                .clickLogin();
        String actualTitle = orangeHRMhomePage.getTitle();
        Assertions
                .assertThat(actualTitle)
                .isEqualTo("OrangeHRM");


        actualTitle = orangeHRMhomePage
                .clickWelcome()
                .clickLogout()
                .getTitle();

        Assertions
                .assertThat(actualTitle)
                .isEqualTo("OrangeHRM");
    }

    @Test(enabled = false)
    // A test method that calls the logout method of the OrangeHRMHomePage class and then calls the getTitle method of the
    // OrangeHRMHomePage class
    public void logout() throws Exception {

        String actualTitle = orangeHRMhomePage
                .clickWelcome()
                .clickLogout()
                .getTitle();

        Assertions
                .assertThat(actualTitle)
                .isEqualTo("OrangeHRM");
    }


}
