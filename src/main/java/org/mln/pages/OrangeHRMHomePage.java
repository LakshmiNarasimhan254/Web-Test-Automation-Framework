package org.mln.pages;

import org.mln.driver.DriverManager;
import org.mln.enums.WaitConditions;
import org.mln.reports.ExtentLogger;

import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {
    private  final By linkwelcome = By.xpath("//p[(text()='Paul Collings')]");
    private  final By linklogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome(){
        click(linkwelcome, WaitConditions.PRESENT,"Welcome Link");
        return this;
    }

    public OrangeHRMLoginPage clickLogout(){
        click(linklogout, WaitConditions.CLICKABLE,"LogOut button");
        return new OrangeHRMLoginPage();
    }

    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
