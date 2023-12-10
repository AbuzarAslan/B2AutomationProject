package com.loop.test.task.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        //      create driver object
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//      1. Open a Chrome browser
//      2. Go to: https://www.etsy.com
        driver.get("https://www.etsy.com");
        WebElement input = driver.findElement(By.id("global-enhancements-search-query"));
//      3. Search for “wooden spoon”
        input.sendKeys("wooden spoon", Keys.ENTER);
//      4. Verify title:
//      Expected: “Wooden spoon | Etsy”
        System.out.println(driver.getTitle().contains("Wooden spoon | Etsy") ? "TEST PASSED -> Title contains \"Wooden spoon | Etsy\"" :
                "TEST FAILED -> Title cannot equal \"Wooden spoon | Etsy\"");
        driver.quit();
    }
}