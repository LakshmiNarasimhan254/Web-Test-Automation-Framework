package org.mln.pages.automationExercise;

import org.mln.enums.WaitConditions;
import org.mln.pages.BasePage;
import org.mln.utils.DecodeUtil;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignUpPage extends BasePage {
    private By hdrEnterAccountInformation = By.xpath("(//h2[@class='title text-center'])[1]");
    private By rdbtnMr = By.id("id_gender1");
    private By rdbtnMrs = By.id("id_gender2");
    private By txtbxName = By.id("name");
    private By txtbxEmail = By.id("email");
    private By txtbxPassword = By.id("password");
    private By drpdnDay = By.id("days");
    private By drpdbMonth = By.id("months");
    private By drpdnYear = By.id("years");
    private By chkbxSignUpForNewsLetter = By.id("newsletter");
    private By chkbxReceiveSpecialOffers = By.id("optin");
    private By txtFirstName = By.id("first_name");
    private By txtLastName = By.id("last_name");
    private By txtCompany = By.id("company");
    private By txtAddress1 = By.id("address1");
    private By txtAddress2 = By.id("address2");
    private By drpdncountry = By.id("country");
    private By txtState = By.id("state");
    private By txtCity = By.id("city");
    private By txtZipCode = By.id("zipcode");
    private By txtMobileNumber = By.id("mobile_number");
    private By btnCreateAccount = By.xpath("//button[text()='Create Account']");

    public String getEnterAccountInformationText() {
        return seleniumInteractions.getElementText(hdrEnterAccountInformation,WaitConditions.VISIBLE,"Enter Account Information Title");
    }

    public void chooseTitle(String title) {
        switch (title.toUpperCase().trim()) {
            case "MR":
                seleniumInteractions.click(rdbtnMr,WaitConditions.CLICKABLE,"Title");
                break;
            case "MRS":
                seleniumInteractions.click(rdbtnMrs,WaitConditions.CLICKABLE,"Title");
                break;
            default:
                seleniumInteractions.click(rdbtnMr,WaitConditions.CLICKABLE,"Title");
                break;
        }
    }

    public void enterName(String name) {
        seleniumInteractions.enterText(txtbxName, name, WaitConditions.VISIBLE,"Name");
    }

    public void enterPassword(String password) {
        seleniumInteractions.enterText(txtbxPassword, DecodeUtil.base64Decode(password),WaitConditions.VISIBLE,"Password");
    }

    public void enterDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date localdate = formatter.parse(date);
            seleniumInteractions.selectByIndex(drpdnDay, Integer.parseInt(new SimpleDateFormat("dd").format(localdate)),WaitConditions.CLICKABLE,"Day");
            seleniumInteractions.selectByVisibleText(drpdbMonth, new SimpleDateFormat("MMMM").format(localdate),WaitConditions.CLICKABLE,"Day");
            seleniumInteractions.selectByVisibleText(drpdnYear, new SimpleDateFormat("yyyy").format(localdate),WaitConditions.CLICKABLE,"Day");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public void checkSignUpForNewsLetter() {
        seleniumInteractions.check(chkbxSignUpForNewsLetter,WaitConditions.CLICKABLE,"Sign up check box");
    }

    public void chkbxReceiveSpecialOffers() {
        seleniumInteractions.check(chkbxReceiveSpecialOffers,WaitConditions.CLICKABLE,"Receive Special check box");
    }

    public void enterFirstName(String name) {
        seleniumInteractions.enterText(txtFirstName, name,WaitConditions.VISIBLE,"First Name");
    }

    public void enterLastName(String name) {
        seleniumInteractions.enterText(txtLastName, name,WaitConditions.VISIBLE,"Last Name");
    }

    public void enterCompany(String companyName) {
        seleniumInteractions.enterText(txtCompany, companyName, WaitConditions.VISIBLE,"Company Name");
    }

    public void enterAddressLine1(String addressLine) {
        seleniumInteractions.enterText(txtAddress1, addressLine, WaitConditions.VISIBLE,"Address Line 1");
    }

    public void enterAddressLine2(String addressLine) {
        seleniumInteractions.enterText(txtAddress2, addressLine, WaitConditions.VISIBLE,"Address Line 2");
    }

    public void selectCountry(String Country) {
        seleniumInteractions.selectByValue(drpdncountry, Country,  WaitConditions.CLICKABLE,"Country");
    }

    public void enterState(String state) {
        seleniumInteractions.enterText(txtState, state,WaitConditions.VISIBLE,"State");
    }

    public void enterCity(String city) {
        seleniumInteractions.enterText(txtCity, city,WaitConditions.VISIBLE,"City");
    }

    public void enterZipCode(String zipCode) {
        seleniumInteractions.enterText(txtZipCode, zipCode,WaitConditions.VISIBLE,"Zipcode");
    }

    public void enterMobileNumber(String mobileNumber) {
        seleniumInteractions.enterText(txtMobileNumber, mobileNumber,WaitConditions.VISIBLE,"Mobile Number");
    }

    public void submitCreateAccount() {
        seleniumInteractions.click(btnCreateAccount,WaitConditions.CLICKABLE,"Create Account button");
    }

}

