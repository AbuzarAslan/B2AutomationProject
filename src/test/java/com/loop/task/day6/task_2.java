package com.loop.task.day6;


import com.loop.test.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class task_2 extends TestBase {
    @Test
    public void test2() {
        /*
        1. go to https://demoqa.com/nestedframes
2. Validate "Child Iframe" text
3. Validate "Parent Iframe" text
4. Validate the "Sample Nested Iframe page. There are nested iframes in this page.
Use browser inspector or firebug to check out the HTML source.
In total, you can switch between the parent frame and the nested child frame."
         */
        driver.get("https://demoqa.com/nestedframes");
        List <WebElement> list = new ArrayList<>();
        list = driver.findElements(By.xpath("//iframe"));
        System.out.println("Iframe size is: " + list.size());

        WebElement validatePage = driver.findElement(By.xpath("//div[@id='framesWrapper']"));
        actual = validatePage.getText();
        expected = "Sample Nested Iframe page. There are nested iframes in this page." +
                " Use browser inspector or firebug to check out the HTML source." +
                " In total you can switch between the parent frame and the nested child frame.";
        Assert.assertEquals(actual, expected);

        driver.switchTo().frame("frame1");
        WebElement parentIframe = driver.findElement(By.xpath("//body[text()='Parent frame']"));

        actual = parentIframe.getText();
        expected = "Parent frame";
        System.out.println(actual + " <- equals to -> " + expected);
        Assert.assertEquals(actual, expected);

        WebElement switchToChild = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));

        driver.switchTo().frame(switchToChild);

        WebElement childIframe = driver.findElement(By.xpath("//p[text()='Child Iframe']"));
        actual = childIframe.getText();
        expected = "Child Iframe";
        System.out.println(actual + " <- equals to -> " + expected);
        Assert.assertEquals(actual, expected);
    }
}
