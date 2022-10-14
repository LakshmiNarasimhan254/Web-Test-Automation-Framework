package org.mln.testcases;


import org.assertj.core.api.Assertions;
import org.mln.driver.Driver;
import org.mln.driver.DriverManager;
import org.mln.pages.OrangeHRM_HomePage;
import org.mln.pages.OrangeHRM_LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public final class LoginPageTest extends BaseTest{
    OrangeHRM_LoginPage orangeHRM_loginPage =new OrangeHRM_LoginPage();
    OrangeHRM_HomePage orangeHRM_homePage;
    private LoginPageTest() {
    }

    @Test
    public void login(){
        String actualTitle = orangeHRM_loginPage
                                .enterUserName("Admin")
                                .enterPassword("admin123")
                                .clickLogin()
                                .getTitle();
        Assertions
                .assertThat(actualTitle)
                .isEqualTo("OrangeHRM");
    }
    @Test
    public void logout(){
        String actualTitle = orangeHRM_homePage
                            .clickWelcome()
                            .clickLogout()
                            .getTitle();

       Assertions
                .assertThat(actualTitle)
                .isEqualTo("OrangeHRM");
    }



}
