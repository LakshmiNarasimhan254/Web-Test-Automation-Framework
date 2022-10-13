package org.mln.testcases;


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
        orangeHRM_homePage= orangeHRM_loginPage.enterUserName("Admin").enterPassword("admin123").clickLogin();
    }
    @Test
    public void logout(){
       orangeHRM_homePage.clickWelcome().clickLogout();
    }



}
