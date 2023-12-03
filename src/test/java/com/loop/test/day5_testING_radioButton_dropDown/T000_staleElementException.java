package com.loop.test.day5_testING_radioButton_dropDown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T000_staleElementException {

    public static void main(String[] args) {
        //        1. Open Chrome browser
//        2. Go to http://the-internet.herokuapp.com/add_remove_elements/
//        3. Click to “Add Element” button
//        4. Verify “Delete” button is displayed after clicking.
//        5. Click to “Delete” button.
//        6. Verify “Delete” button is NOT displayed after clicking.
//
        // open the browser and navigate

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // click the ADD Button

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add Element')]"));
        addButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));

        if(deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed");
        } else {
            System.out.println("Delete button is not displayed");
        }
        deleteButton.click();

        if(deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed");
        } else {
            System.out.println("Delete button is not displayed");
        }

        try {
            deleteButton.isDisplayed();
        } catch(StaleElementReferenceException s){
            System.out.println("Exception handled");
            System.out.println("Element is not displayed anymore");
        }

        driver.quit();



    }
}
