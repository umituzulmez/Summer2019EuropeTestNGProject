package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
       driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod(){
        //driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //locating and clicking destroy button
        driver.findElement(By.xpath("//*[.='Destroy the World']")).click();

        //locating No button and clicking it
        driver.findElement(By.xpath("//*[.='No']")).click();
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //Click for JS Alert
        driver.findElement(By.xpath("//button[1]")).click();

        //controlling alert using with alert class
        Alert alert = driver.switchTo().alert();

        //accept alert --> clicking ok in alerts
        alert.accept();

        //Click for JS Alert
        driver.findElement(By.xpath("//button[2]")).click();

        //dismiss alert --> clicking x to close,  selecting no/cancel in alerts
        alert.dismiss();

        //Click for JS Alert
        driver.findElement(By.xpath("//button[3]")).click();

        //sendKeys() --> send some keys
        alert.sendKeys("Mike Smith");

        //when we send the text, we might not see the text in the inputbox. You may see it is sent under the box written
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);

    }
}
