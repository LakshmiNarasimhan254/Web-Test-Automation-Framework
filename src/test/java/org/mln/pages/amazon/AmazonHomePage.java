package org.mln.pages.amazon;




import org.mln.enums.WaitConditions;
import org.mln.pages.BasePage;
import org.mln.utils.DynamicXPathUtil;
import org.openqa.selenium.By;

/**
 * This class is a page object class for the Amazon home page. It contains methods to click on the hamburger menu and its
 * options
 */
public class AmazonHomePage extends BasePage {


    private By lnkHamburgerMenu = By.xpath("//span[text()='All']/parent::a");
    private String lnkHamburgerMenuOptions = "//div[text()='%s']/parent::a";
    // A dynamic xpath.
    private String lnkHamburgerSubMenu = "//a[contains(text(),'%s')]";
    /**
     * This function clicks on the hamburger menu link on the Amazon home page
     *
     * @return The AmazonHomePage object is being returned.
     */
    public AmazonHomePage clickHamburgerMenu() {
        seleniumInteractionsUtil.click(lnkHamburgerMenu, WaitConditions.CLICKABLE, "ALL");

        return this;
    }


    /**
     * This function clicks on the hamburger menu options on the Amazon home page
     *
     * @param menuOptionsName The name of the menu option you want to click on.
     * @return The AmazonHomePage class is being returned.
     */
    public AmazonHomePage clickHamburgerMenuOptions(String menuOptionsName) {
        String linkSeeAll = DynamicXPathUtil.getDynamicXpath(lnkHamburgerMenuOptions, "see all");
        if (seleniumInteractionsUtil.isElementDisplayed(linkSeeAll)) {
            seleniumInteractionsUtil.click((By.xpath(linkSeeAll)), WaitConditions.CLICKABLE, "see all");
        }
        seleniumInteractionsUtil.click(By.xpath(DynamicXPathUtil.getDynamicXpath(lnkHamburgerMenuOptions, menuOptionsName)),
                WaitConditions.CLICKABLE, menuOptionsName);

       return this;
    }
    /**
     * It clicks on the hamburger menu and then clicks on the submenu item
     *
     * @param subMenuName The name of the sub menu item to click on.
     * @return The page object of the next page.
     */
    public Object clickHamburgerSubMenu(String subMenuName)  {
        seleniumInteractionsUtil.click(By.xpath(DynamicXPathUtil.getDynamicXpath(lnkHamburgerSubMenu, subMenuName)),
                WaitConditions.CLICKABLE, subMenuName);

        if (subMenuName.contains("Tablets")){
            return  new AmazonComputersTabletsPCProductsPage();
        }
        return null;
    }


}
