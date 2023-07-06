package org.mln.pages.automationExercise;

import org.mln.enums.WaitConditions;
import org.mln.pages.BasePage;
import org.openqa.selenium.By;

public class SignUp_LoginPage extends BasePage {

    private By hdrNewUserSignUp= By.xpath("//h2[text()='New User Signup!']");
    private By txtbxName = By.name("name");
    private By txtbxEmail = By.xpath("//input[@data-qa='signup-email']");

    private By btnSignUp = By.xpath("//button[text()='Signup']");

    public String getheaderText(){
        return seleniumInteractions.getElementText(hdrNewUserSignUp, WaitConditions.VISIBLE,"New User Signup Title");
    }
    public void enterName(String name){
        seleniumInteractions.enterText(txtbxName,name,WaitConditions.VISIBLE,"Name");
    }
    public void enterEmail(String email){
        seleniumInteractions.enterText(txtbxEmail,email,WaitConditions.VISIBLE,"Email");
    }
    public void clickSignUp(){
        seleniumInteractions.click(btnSignUp,WaitConditions.CLICKABLE,"Sign up Button");
    }

}

