package org.mln.pages;

import org.mln.driver.DriverManager;
import org.mln.reports.ExtentReport;
import org.mln.reports.ExtentReportManager;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage {
    private  final By linkwelcome = By.xpath("//p[@class ='oxd-userdropdown-name']");
    private  final By linklogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome(){
        DriverManager.getDriver().findElement(linkwelcome).click();
        ExtentReportManager.getExtentTest().pass("Welcome Link is clicked successfully");
        return this;
    }

    public OrangeHRMLoginPage clickLogout(){
        DriverManager.getDriver().findElement(linklogout).click();
        ExtentReportManager.getExtentTest().pass("Logout is clicked successfully");
        return new OrangeHRMLoginPage();
    }

    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
