package com.loop.test.task.day4;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Href {
    /*
    1. go to docuport app
2. validate that Home, Received docs, My uploads, Invitations are displayed
3. press three lines
4. Home, Received docs, My uploads, Invitations will disappear
5. Validate the buttons are not displayed
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();


        driver.get("https://beta.docuport.app/login?redirect=%2F");

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(DocuportConstants.USERNAME_CLIENT);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(DocuportConstants.PASSWORD_CLIENT, Keys.ENTER);

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(3000);
        WebElement homeDriver = driver.findElement(By.xpath("//span[text()='Home']"));
        System.out.println("Actual result --> " + homeDriver.getText() + " is displayed ? " + homeDriver.isDisplayed());

        Thread.sleep(3000);
        WebElement receivedDocument = driver.findElement(By.xpath("//span[text()='Received docs']"));
        System.out.println("Actual result --> " + homeDriver.getText() + " is displayed ? " + homeDriver.isDisplayed());


        Thread.sleep(3000);
        WebElement myUploads = driver.findElement(By.xpath("//span[text()='My uploads']"));

        Thread.sleep(3000);
        WebElement invitations = driver.findElement(By.xpath("//span[text()='Invitations']"));




        driver.quit();


    }
}