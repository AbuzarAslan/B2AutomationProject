package com.loop.task.day5;


import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class task_2 {
    WebDriver driver;
    String actual;
    String expected;

    @BeforeClass
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
    @Test
    public void getEtsyWebsite() throws InterruptedException {
        driver.get("https://www.etsy.com/");
        WebElement search = driver.findElement(By.xpath("//input[@name='search_query']"));
        search.sendKeys("rings" + Keys.ENTER);

        WebElement estimatedArrival = driver.findElement(By.xpath("//span[@class='wt-menu__trigger__label']/span"));
        Assert.assertEquals(estimatedArrival.getText(), "Estimated Arrival Any time", "Test PASSED");

        estimatedArrival.click();

        WebElement selectDayButton = driver.findElement(By.xpath("//select[@id='edd_select_tf']"));

        Select customDate = new Select(selectDayButton);
        selectDayButton.click();
        customDate.selectByVisibleText("By Dec 30");
        expected = customDate.getFirstSelectedOption().getText();
        actual = estimatedArrival.getText();
        Assert.assertTrue(actual.contains(expected));

    }
}