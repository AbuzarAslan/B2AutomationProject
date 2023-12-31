package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_uploads {



    @Test
    public void upload_file(){
        Driver.getDriver().get(ConfigurationReader.getProperty("guru.url"));
        WebElement chooseFile= Driver.getDriver().findElement(By.id("uploadfile_0"));
        String path = "C:\\Users\\abuza\\Downloads\\note.txt";
        chooseFile.sendKeys(path);

        WebElement checkBox = Driver.getDriver().findElement(By.id("terms"));
        checkBox.click();

        WebElement submitButton = Driver.getDriver().findElement(By.id("submitbutton"));
        submitButton.click();
        WebElement successMessage = Driver.getDriver().findElement(By.id("res"));
        String expectedMessage = "1 file\nhas been successfully uploaded.";
        assertEquals(successMessage.getText(), expectedMessage);

        // Driver.closeDriver();



}
}
