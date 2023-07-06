package org.mln.testcases.automationExercise;

import org.assertj.core.api.Assertions;
import org.mln.annotations.TestInfo;
import org.mln.enums.Categories;
import org.mln.pages.automationExercise.AccountCreatedPage;
import org.mln.pages.automationExercise.HomePage;
import org.mln.pages.automationExercise.SignUpPage;
import org.mln.pages.automationExercise.SignUp_LoginPage;
import org.mln.testcases.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class RegisterUserTests extends BaseTest {

    @TestInfo(author = {"Lakshmi Mohan"},categories = {Categories.FUNCTIONAL,Categories.SMOKE})
    @Test
    public void registerUser(Integer runCount , HashMap<String,String> testdata) {
        HomePage homePage = new HomePage();
        SignUp_LoginPage signup_loginPage = new SignUp_LoginPage();
        SignUpPage signUpPage = new SignUpPage();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
        homePage.clickSignUp();
        String strSignUpHeader = signup_loginPage.getheaderText();
        Assertions.assertThat(strSignUpHeader).isEqualTo(testdata.get("Expected Page Header 1"));
        signup_loginPage.enterName(testdata.get("UserName"));
        signup_loginPage.enterEmail(testdata.get("Email"));
        signup_loginPage.clickSignUp();
        String strAccountInformationHeader = signUpPage.getEnterAccountInformationText();
        Assertions.assertThat(strAccountInformationHeader).isEqualTo(testdata.get("Expected Page Header 2"));
        signUpPage.chooseTitle(testdata.get("Title"));
        signUpPage.enterName(testdata.get("Name"));
        signUpPage.enterPassword(testdata.get("Password"));
        signUpPage.enterDate(testdata.get("Date"));
        signUpPage.checkSignUpForNewsLetter();
        signUpPage.enterFirstName(testdata.get("FirstName"));
        signUpPage.enterLastName(testdata.get("LastName"));
        signUpPage.enterCompany(testdata.get("Company"));
        signUpPage.enterAddressLine1(testdata.get("Address Line 1"));
        signUpPage.enterAddressLine2(testdata.get("Address Line 2"));
        signUpPage.selectCountry(testdata.get("Country"));
        signUpPage.enterState(testdata.get("State"));
        signUpPage.enterCity(testdata.get("City"));
        signUpPage.enterZipCode(testdata.get("Zipcode"));
        signUpPage.enterMobileNumber(testdata.get("Mobile Number"));
        signUpPage.submitCreateAccount();
        Assertions.assertThat(accountCreatedPage.getTxtAccountCreatedText("ACCOUNT CREATED!")).isEqualTo(testdata.get("Expected Success Message 1"));
        accountCreatedPage.clickContinue();
        Assertions.assertThat(homePage.getLoggedInUser()).isEqualTo(testdata.get("Expected Logged User"));
        homePage.clickDeleteAccount();
        Assertions.assertThat(accountCreatedPage.getTxtAccountDeletedText()).isEqualTo(testdata.get("Expected Success Message 2"));
        accountCreatedPage.clickContinue();


    }

    @Test
    public void test() {

    }
}

