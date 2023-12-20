package com.loop.task.day6;

import com.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task_1 extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement timerAlertButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        timerAlertButton.click();
        Thread.sleep(5000);
        alert.accept();

        // confirmButton
        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmButton.click();
        alert.accept();

        WebElement validateMessage = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        actual = validateMessage.getText();
        System.out.println(actual); // -> You selected Ok
        expected = "You selected Ok";
        Assert.assertEquals(actual, expected);

        confirmButton.click();
        alert.dismiss();
        actual = validateMessage.getText();
        System.out.println(actual); // -> You selected Cansel
        expected = "You selected Cancel";
        Assert.assertEquals(actual, expected);

        // promtButton
        WebElement promptButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
        promptButton.click();
        alert.sendKeys("Loop Academy");
        alert.accept();

        WebElement validateMessagePrompt = driver.findElement(By.xpath("//span[@id='promptResult']"));
        actual = validateMessagePrompt.getText();
        System.out.println(actual); // -> You entered Loop Academy
        expected = "You entered Loop Academy";
        Assert.assertEquals(actual, expected);
    }
}