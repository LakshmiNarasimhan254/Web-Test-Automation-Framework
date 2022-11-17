package org.mln.testcases;

import org.assertj.core.api.Assertions;
import org.mln.annotations.TestInfo;
import org.mln.pages.AmazonComputersTabletsPCProductsPage;
import org.mln.pages.AmazonHomePage;
import org.testng.annotations.Test;

import java.util.HashMap;

public final class AmazonHomePageTest extends BaseTest{

      AmazonHomePage amazonHomePage= new AmazonHomePage();
      AmazonComputersTabletsPCProductsPage amazonComputersTabletsPCProductsPage;

      private  AmazonHomePageTest(){}
    @TestInfo(author = {"Lakshmi Mohan"},categories = {"Regression"})
    @Test
    public void verifyAmazonHamburgerSubMenuPageTitle(Integer runCount , HashMap<String,String> testdata) throws Exception {
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
