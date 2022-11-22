package org.mln.testcases;

import static org.assertj.core.api.Assertions.*;
import org.mln.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * This class extends the BaseTest class and has a private constructor. It has a test method that validates the title of
 * the page, the presence of a link and the number of links displayed
 */
public class HomePageTest extends BaseTest{


    private HomePageTest() {
    }
    /*

        validate if the title is not null and length is >15 and <100
        validate if the title of the page contains "google search"
        check for links in the page-->validate the presence of "Testing mini bytes -youtube"
        number of valid link displayed = 10

     */

    @Test
    public void test2(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();
        assertThat(title)
                .as("Title is null").isNotNull()
                .as("The length of " +title+ " is not in between 15 and 100").hasSizeBetween(15,100)
                .as(title + " does not contain google search") .containsIgnoringCase("goOgle Search");

        List<WebElement> links = DriverManager.getDriver().findElements(By.xpath("//div/a/h3"));
        assertThat(links)
                .as("The Total links is not equal to 10").hasSize(8)
                .as("There is no link with name Testing mini byte") .extracting(e->e.getText().equalsIgnoreCase("Testing Mini Bytes - YouTube"));

    }
}
