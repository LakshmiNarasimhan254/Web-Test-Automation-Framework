package org.mln.pages.automationExercise;

import org.mln.enums.WaitConditions;
import org.mln.pages.BasePage;
import org.mln.utils.DynamicXPathUtil;
import org.mln.utils.SeleniumInteractionsUtil;
import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage {
    // A dynamic xpath.
    private String txtAccountCreated = "//b[text()='%s']";
    private By txtAccountDeleted =By.xpath("//b[text()='Account Deleted!']");
    private By btnContinue =By.xpath("//a[contains(text(),'Continue')]");
    public String getTxtAccountCreatedText(String titleText) {
        return seleniumInteractionsUtil.getElementText( By.xpath(DynamicXPathUtil.getDynamicXpath(txtAccountCreated,titleText)), WaitConditions.VISIBLE,"Account Created Text");

    }
    public String getTxtAccountDeletedText() {
        return seleniumInteractionsUtil.getElementText(txtAccountDeleted,WaitConditions.VISIBLE,"Account Deleted Text");

    }

    public void clickContinue(){
        seleniumInteractionsUtil.click(btnContinue,WaitConditions.CLICKABLE,"Continue Button");
    }
}
