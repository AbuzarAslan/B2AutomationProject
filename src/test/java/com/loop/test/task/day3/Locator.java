package com.loop.test.task.day3;

import com.loop.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 1. go to https://loopcamp.vercel.app/forgot-password.html
 * 2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
 * 3. use css
 * 4. verify those elements are displayed
 */

public class Locator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/forgot-password.html");

        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class='example']>h2"));
        System.out.println(forgotPassword.isDisplayed());

        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        System.out.println(email.getText());


        driver.quit();







    }

}
