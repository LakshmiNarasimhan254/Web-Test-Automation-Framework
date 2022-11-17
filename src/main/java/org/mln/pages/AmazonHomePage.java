package org.mln.pages;




import org.mln.enums.WaitConditions;
import org.mln.utils.DynamicXPathUtil;
import org.openqa.selenium.By;

public class AmazonHomePage extends BasePage {


    private By linkHamurgerMenu = By.xpath("//span[text()='All']/parent::a");
    private String linkHamburgerMenuOptions = "//div[text()='%s']/parent::a";
    private String linkHamburgerSubMenu = "//a[contains(text(),'%s')]";
    public AmazonHomePage clickHamburgerMenu() throws Exception {
        click(linkHamurgerMenu, WaitConditions.CLICKABLE, "ALL");
        return this;
    }


    public AmazonHomePage clickHamburgerMenuOptions(String menuOptionsName) throws Exception {
        String linkSeeAll = DynamicXPathUtil.getDynamicXpath(linkHamburgerMenuOptions, "see all");
        if (isElementDisplayed(linkSeeAll)) {
            click((By.xpath(linkSeeAll)), WaitConditions.CLICKABLE, "see all");
        }
        click(By.xpath(DynamicXPathUtil.getDynamicXpath(linkHamburgerMenuOptions, menuOptionsName)),
                WaitConditions.CLICKABLE, menuOptionsName);

       return this;
    }
    public Object clickHamburgerSubMenu(String subMenuName) throws Exception {
           click(By.xpath(DynamicXPathUtil.getDynamicXpath(linkHamburgerSubMenu, subMenuName)),
                WaitConditions.CLICKABLE, subMenuName);

        if (subMenuName.contains("Tablets")){
            return  new AmazonComputersTabletsPCProductsPage();
        };
        return null;
    }


}
