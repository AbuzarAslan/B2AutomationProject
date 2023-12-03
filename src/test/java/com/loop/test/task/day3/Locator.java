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
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/forgot-password.html");

        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class='example']>h2"));
        System.out.println(forgotPassword.isDisplayed());

        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        System.out.println(email.getText());


        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));
        WebElement retrievePassword = driver.findElement(By.cssSelector("button[id='form_submit']>i"));
        WebElement poweredByLOOPCAMP = driver.findElement(By.cssSelector("div[class='large-4 large-centered columns'].div"));

        System.out.println(forgotPassword.isDisplayed());
        System.out.println(email.isDisplayed());
        System.out.println(emailInput.isDisplayed());
        System.out.println(retrievePassword.isDisplayed());
        System.out.println(poweredByLOOPCAMP.isDisplayed());


        driver.quit();

        WebElement clickButton = driver.findElement(By.cssSelector("span[class='subtitle-2 text-none pl-2 pr-3 gray--text text--darken-3']"));
        clickButton.click();


        WebElement logOutButton = driver.findElement(By.id("list-item-153"));
        logOutButton.click();
        if (logOutButton.isDisplayed()) {
            System.out.println("Log out button is Displayed.Test PASSED");
        } else {
            System.out.println("Log out button is not Displayed.Test FAILED");
        }

        Thread.sleep(3000);

        driver.quit();
    }}








