package com.loop.task.day5;


import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class task_3 {
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
    public void getWebsite() throws InterruptedException {

        driver.get(DocuportConstants.CURRENT_LOGIN_URL);
        WebElement goToDocPage = driver.findElement(By.xpath("//input[@id='input-14']"));
        goToDocPage.sendKeys(DocuportConstants.USERNAME_CLIENT + Keys.TAB + DocuportConstants.PASSWORD_CLIENT + Keys.ENTER);
        Thread.sleep(3000);

        WebElement receivedDoc = driver.findElement(By.xpath("//div[@class='doc-card--icon d-flex justify-end']"));
        receivedDoc.click();
        WebElement search = driver.findElement(By.xpath("//button[@class='mr-3 mb-1 mb-sm-0 v-btn v-btn--has-bg theme--light v-size--large']"));
        search.click();


        WebElement status = driver.findElement(By.xpath("//input[@id='input-120']"));
        status.click();
        Thread.sleep(3000);

        WebElement inProgress = driver.findElement(By.xpath("//div[@class='v-list-item__title' and text()='In progress']"));
        inProgress.click();
        System.out.println(inProgress.getText());

        actual = inProgress.getText();
        expected = "In progress";
        Assert.assertEquals(actual, expected, "TEST PASSED");

    }
}