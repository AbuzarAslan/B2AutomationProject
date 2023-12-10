package com.loop.test.task.day4;


import com.loop.test.utilities.DocuportConstants;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class task_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 1. Go to docuport app
        driver.get("https://beta.docuport.app/login");
        driver.manage().window().maximize();
        // Enter login
        WebElement goToLogin = driver.findElement(By.xpath("//input[@id='input-14']"));
        goToLogin.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        // Enter password
        WebElement goToPassword = driver.findElement(By.xpath("//input[@id='input-15']"));
        goToPassword.sendKeys(DocuportConstants.PASSWORD_ADVISOR + Keys.ENTER);
        // Need to sleep a little bit
        Thread.sleep(3000);

        WebElement threeLines = driver.findElement(By.xpath("//button[@class='v-app-bar__nav-icon v-btn v-btn--icon v-btn--round theme--light v-size--default']"));
        threeLines.click();

        List<WebElement> findElements = driver.findElements(By.xpath("//a"));
        System.out.println(findElements.size());
        int countGetText = 0; // it will be countGetText = 11;
        for (WebElement each : findElements) {
            System.out.println("Items: " + each.getText());
            System.out.println("Items with \"href\" value: " + each.getAttribute("href"));
            if (each.getText().isBlank()) {
                countGetText++;
            }
        }
        if (countGetText == findElements.size()) {
            System.out.println("Expected matching to actual");
        } else {
            System.out.println("Expected is NOT matching to actual");
        }
        driver.quit();
    }
}
