package org.mln.pages;




import org.mln.enums.WaitConditions;
import org.mln.utils.DynamicXPathUtil;
import org.openqa.selenium.By;

/**
 * This class is a page object class for the Amazon home page. It contains methods to click on the hamburger menu and its
 * options
 */
public class AmazonHomePage extends BasePage {


    private By linkHamburgerMenu = By.xpath("//span[text()=\'All\']/parent::a");
    private String linkHamburgerMenuOptions = "//div[text()=\'%s\']/parent::a";
    // A dynamic xpath.
    private String linkHamburgerSubMenu = "//a[contains(text(),\'%s\')]";
    /**
     * This function clicks on the hamburger menu link on the Amazon home page
     *
     * @return The AmazonHomePage object is being returned.
     */
    public AmazonHomePage clickHamburgerMenu() {
        click(linkHamburgerMenu, WaitConditions.CLICKABLE, "ALL");
        return this;
    }


    /**
     * This function clicks on the hamburger menu options on the Amazon home page
     *
     * @param menuOptionsName The name of the menu option you want to click on.
     * @return The AmazonHomePage class is being returned.
     */
    public AmazonHomePage clickHamburgerMenuOptions(String menuOptionsName) {
        String linkSeeAll = DynamicXPathUtil.getDynamicXpath(linkHamburgerMenuOptions, "see all");
        if (isElementDisplayed(linkSeeAll)) {
            click((By.xpath(linkSeeAll)), WaitConditions.CLICKABLE, "see all");
        }
        click(By.xpath(DynamicXPathUtil.getDynamicXpath(linkHamburgerMenuOptions, menuOptionsName)),
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
           click(By.xpath(DynamicXPathUtil.getDynamicXpath(linkHamburgerSubMenu, subMenuName)),
                WaitConditions.CLICKABLE, subMenuName);

        if (subMenuName.contains("Tablets")){
            return  new AmazonComputersTabletsPCProductsPage();
        }
        return null;
    }


}
