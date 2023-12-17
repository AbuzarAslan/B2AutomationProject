package com.loop.task.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 1. go to https://loopcamp.vercel.app/forgot-password.html
 * 2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
 * 3. use css
 * 4. verify those elements are displayed
 */
public class task_0 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//      1. go to https://loopcamp.vercel.app/forgot-password.html
        driver.get("https://loopcamp.vercel.app/forgot-password.html");


//      2. locate 5 elements: forgot password, email, email input, retrieve password, powered by LOOPCAMP
//         use cssSelector:
        WebElement forgotPassword = driver.findElement(By.cssSelector("#content > div > h2"));
        WebElement email = driver.findElement(By.cssSelector("#forgot_password > div > div > label"));
        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        WebElement retrievePassword = driver.findElement(By.cssSelector("#form_submit > i"));
        WebElement poweredByLoopcamp = driver.findElement(By.cssSelector("#page-footer > div > div > a"));

//      3. verify those elements are displayed
        checkLocationOfElement(forgotPassword, "forgot password");
        Thread.sleep(2000);
        checkLocationOfElement(email, "email");
        Thread.sleep(2000);
        checkLocationOfElement(emailInput, "email input");
        Thread.sleep(2000);
        checkLocationOfElement(retrievePassword, "retrievePassword");
        Thread.sleep(2000);
        checkLocationOfElement(poweredByLoopcamp, "powered by LOOPCAMP");
        Thread.sleep(2000);

        driver.quit();
    }
    public static void checkLocationOfElement (WebElement element, String elementName) {
        if (element.isDisplayed()) {
            System.out.println("String \"" + elementName + "\" is located -> TEST PASSED");
        } else {
            System.out.println("String \"" + elementName + "\" is NOT located -> TEST FAILED");
        }
    }
}
