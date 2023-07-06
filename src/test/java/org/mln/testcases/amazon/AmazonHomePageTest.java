package org.mln.testcases.amazon;

import org.assertj.core.api.Assertions;
import org.mln.annotations.TestInfo;
import org.mln.enums.Categories;
import org.mln.pages.amazon.AmazonComputersTabletsPCProductsPage;
import org.mln.pages.amazon.AmazonHomePage;
import org.mln.testcases.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * This class is a test class that extends the BaseTest class and uses the AmazonHomePage class to verify the title
 * of the
 * Amazon Computers, Tablets  PC Products page
 */
public final class AmazonHomePageTest extends BaseTest {

    AmazonHomePage amazonHomePage = new AmazonHomePage();
    AmazonComputersTabletsPCProductsPage amazonComputersTabletsPCProductsPage;

    private AmazonHomePageTest() {
    }

    @TestInfo(author = {"Lakshmi Mohan"}, categories = {Categories.FUNCTIONAL, Categories.SMOKE})
    @Test
    // This is a test method that is used to verify the title of the Amazon Computers, Tablets & PC Products page.
    public void verifyAmazonHamburgerSubMenuPageTitle1(Integer runCount, HashMap<String, String> testdata) throws Exception {
        amazonComputersTabletsPCProductsPage =
                (AmazonComputersTabletsPCProductsPage) amazonHomePage
                        .clickHamburgerMenu()
                        .clickHamburgerMenuOptions(testdata.get("HamburgerMenuOption"))
                        .clickHamburgerSubMenu(testdata.get("HamburgerSubMenu"));
        //System.out.println(DriverManager.getDriver().getTitle()+ "please help me");
        Assertions.assertThat(
                        amazonComputersTabletsPCProductsPage
                                .getThisPageTitle())
                .isEqualTo(testdata.get("ExpectedPageTitle"));
    }

    @TestInfo(author = {"Lakshmi Mohan"}, categories = {Categories.FUNCTIONAL, Categories.SMOKE})
    @Test
    // This is a test method that is used to verify the title of the Amazon Computers, Tablets & PC Products page.
    public void verifyAmazonHamburgerSubMenuPageTitle2(Integer runCount, HashMap<String, String> testdata) throws Exception {
        amazonComputersTabletsPCProductsPage =
                (AmazonComputersTabletsPCProductsPage) amazonHomePage
                        .clickHamburgerMenu()
                        .clickHamburgerMenuOptions(testdata.get("HamburgerMenuOption"))
                        .clickHamburgerSubMenu(testdata.get("HamburgerSubMenu"));
        Assertions.assertThat(
                        amazonComputersTabletsPCProductsPage
                                .getThisPageTitle())
                .isEqualTo(testdata.get("ExpectedPageTitle"));
    }
}
