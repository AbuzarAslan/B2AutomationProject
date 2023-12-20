package com.loop.task.day5;


import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class task_1 {
    WebDriver driver;
    String actual;
    String expected = "Please select an option";

    @BeforeClass
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod() {
        //driver.close();
    }

    @Test
    public void getWebsite() {
        // create dropdown
        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        actual = dropDown.getFirstSelectedOption().getText(); // by default
        Assert.assertEquals(actual, expected, "Actual massage are equal expected result");

        dropDown.selectByValue("1");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Option 1", "TEST FAILED");

        dropDown.selectByValue("2");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Option 2", "TEST FAILED");

        WebElement dropdownTitleName = driver.findElement(By.xpath("//h3[contains(text(),'Dropdown List')]"));
        Assert.assertEquals(dropdownTitleName.getText(), "Dropdown List", "TEST FAILED");
    }
}