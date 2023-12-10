package com.loop.test.task.day4;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class task_1 {
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


        // 1. go to Docuport app
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
        System.out.println("Actual result --> " + receivedDocument.getText() + " is displayed ? " + receivedDocument.isDisplayed());


        Thread.sleep(3000);
        WebElement myUploads = driver.findElement(By.xpath("//span[text()='My uploads']"));
        System.out.println("Actual result --> " + myUploads.getText() + " is displayed ? " + myUploads.isDisplayed());

        Thread.sleep(3000);
        WebElement invitations = driver.findElement(By.xpath("//span[text()='Invitations']"));
        System.out.println("Actual result --> " + invitations.getText() + " is displayed ? " + invitations.isDisplayed());


       // Press three lines
        WebElement threeLines = driver.findElement(By.xpath("//button[@class='v-app-bar__nav-icon v-btn v-btn--icon v-btn--round theme--light v-size--default']"));
        threeLines.click();
        Thread.sleep(3000);

        if (!homeDriver.isDisplayed() && !receivedDocument.isDisplayed() && !myUploads.isDisplayed() && !invitations .isDisplayed())
            System.out.println("TEST PASSED -> Home, Received docs, My uploads, Invitations are DISAPPEARED");
        else
            System.out.println("TEST FAILED -> Home, Received docs, My uploads, Invitations are NOT DISAPPEARED!");
        driver.quit();













    }
}