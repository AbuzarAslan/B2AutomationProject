package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {

        // Set up the driver
        WebDriverManager.chromedriver().setup();

        // Create driver (instance) object
        // WebDriver --> interface // new ChromeDriver() --> class
        WebDriver driver = new ChromeDriver();

        // Navigate to the Google
        driver.get("https://www.google.com/");

        //driver.quit();

        // maximize the window
        driver.manage().window().maximize();

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();


        if(actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ", " +
                    "TEST PASS");
        } else {
            System.err.println("Actual title: " + actualTitle + ", DOES NOT match expected title: " + expectedTitle + ", TEST FAIL");
        }






        String expectedURL = "https://www.google.com/";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("Actual url: " + actualURL + ", matches expected url: " + expectedURL + ", => TEST PASS");
        } else {
            System.err.println("Actual url: " + actualURL + ", DOES NOT match expected url: " + expectedURL + ", => TEST FAIL");
        }



        driver.quit();









    }
}