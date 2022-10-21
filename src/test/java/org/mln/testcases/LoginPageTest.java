package org.mln.testcases;


import org.assertj.core.api.Assertions;
import org.mln.pages.OrangeHRMHomePage;
import org.mln.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;


public final class LoginPageTest extends BaseTest{
    OrangeHRMLoginPage orangeHRMloginPage =new OrangeHRMLoginPage();
    OrangeHRMHomePage orangeHRMhomePage;
    private LoginPageTest() {
    }

    @Test
    public void login(){

        orangeHRMhomePage= orangeHRMloginPage
                                .enterUserName("Admin")
                                .enterPassword("admin123")
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
    public void logout(){

        String actualTitle = orangeHRMhomePage
                            .clickWelcome()
                            .clickLogout()
                            .getTitle();

       Assertions
                .assertThat(actualTitle)
                .isEqualTo("OrangeHRM");
    }



}
