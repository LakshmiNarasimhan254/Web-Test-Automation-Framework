package org.mln.testcases;


import org.mln.driver.Driver;
import org.mln.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public final class LoginPageTest extends BaseTest{

    private LoginPageTest() {
    }

    @Test
    public void test1(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }

    @Test
    public void test2(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes", Keys.ENTER);

    }

}
