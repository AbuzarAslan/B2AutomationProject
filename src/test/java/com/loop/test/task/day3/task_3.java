package com.loop.test.task.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

//      create driver object
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//      1. Open a Chrome browser
//      2. Go to: https://google.com
        driver.get("https://google.com");

        driver.navigate().refresh();
        driver.navigate().refresh(); // I used refresh 2-times, because of pop-ups
//      3. Click to Gmail from top right.
        driver.findElement(By.cssSelector("a[class='gb_E'")).click();
//      4. Verify title contains:
//      Expected: Gmail
        System.out.println(driver.getTitle().contains("Gmail") ? "TEST PASSED -> Title contains \"Gmail\"" : "TEST FAILED");
//      5. Go back to Google
        driver.navigate().back();
//      6. Verify title equals:
//      Expected: Google
        System.out.println(driver.getTitle().contains("Google") ? "TEST PASSED -> Title contains \"Google\"" : "TEST FAILED");
        Thread.sleep(3000);

        driver.quit();
    }
}