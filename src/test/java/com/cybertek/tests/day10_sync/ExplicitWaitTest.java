package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        //clicking the start button
        driver.findElement(By.tagName("button")).click();

        //find the username box
        WebElement usernameBox = driver.findElement(By.id("username"));

        //HOW TO WAİT EXPLICITLY?
        //Create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver,20);

        //call until method from wait object
        //waiting for the specific element to be visible (up to 10 sec)
        wait.until(ExpectedConditions.visibilityOf(usernameBox));

        //sending some username
        usernameBox.sendKeys("MikeSmith");
    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();

        //finding input box
        WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));

        //Wait until inputBox is enabled or clickable
        //create to object to wait
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        //type something in the inputbox
        inputBox.sendKeys("something something");
    }
}