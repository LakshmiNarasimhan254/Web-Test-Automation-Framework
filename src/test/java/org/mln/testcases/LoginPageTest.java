package org.mln.testcases;


import org.assertj.core.api.Assertions;
import org.mln.factory.datafactory.ExcelDataProvider;
import org.mln.pages.OrangeHRMHomePage;
import org.mln.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;

import java.util.HashMap;


public final class LoginPageTest extends BaseTest{
    OrangeHRMLoginPage orangeHRMloginPage =new OrangeHRMLoginPage();
    OrangeHRMHomePage orangeHRMhomePage;
    private LoginPageTest() {
    }

    @Test
    public void login(Integer runCount ,HashMap<String,String>testdata) throws Exception {


        orangeHRMhomePage= orangeHRMloginPage
                                .enterUserName(testdata.get("UserName"))
                                .enterPassword(testdata.get("Password"))
                                .clickLogin();
        String actualTitle =orangeHRMhomePage.getTitle();
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
