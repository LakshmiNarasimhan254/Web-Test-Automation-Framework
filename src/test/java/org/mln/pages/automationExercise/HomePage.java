package org.mln.pages.automationExercise;

import org.mln.enums.WaitConditions;
import org.mln.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage

{
        WebDriver driver = null;

        private By lnkSignup = By.xpath("//a[contains(text(),'Signup / Login')]");
        private By lnkDeleteAccount = By.xpath("//a[contains(text(),'Delete Account')]");
        private By txtLoggedUser = By.xpath("//a[contains(text(),' Logged in as ')]/b");

        public void clickSignUp(){
                seleniumInteractions.click(lnkSignup, WaitConditions.CLICKABLE,"Signup Link");
        }
        public void clickDeleteAccount(){
                seleniumInteractions.click(lnkDeleteAccount,WaitConditions.CLICKABLE,"Delete Account Link");
        }
        public String getLoggedInUser(){
                return seleniumInteractions.getElementText(txtLoggedUser,WaitConditions.VISIBLE,"Logged User");
        }
}
