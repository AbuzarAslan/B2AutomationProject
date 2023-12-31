package com.loop.test.task.day3;


import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Task 4
 * ================
 * 1. Open Chrome browser.
 * 2. Go to https://www.etsy.com
 * 3. Search for “wooden spoon”
 * 4. Verify title:
 * Expected: “Wooden spoon | Etsy”
 */

public class Title {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

        WebElement woodenSpoon = driver.findElement(By.id("global-enhancements-search-query"));

        woodenSpoon.sendKeys("wooden spoon" + Keys.ENTER);
    }
}