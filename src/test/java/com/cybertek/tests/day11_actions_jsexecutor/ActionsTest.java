package com.cybertek.tests.day11_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest {

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
    public void hoverTest(){

        driver.get("http://practice.cybertekschool.com/hovers");

        //Actions --> class that contains all the user interactions
        //how to create actions object / passing driver as a constructor
        Actions actions = new Actions(driver);

        WebElement img = driver.findElement(By.tagName("img"));

        //perform() --> perform the action. complete the action
        //moveToElement() --> move your mouse to webelement (hoverover)
        actions.moveToElement(img).perform();

        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed(),"verify view profile is displayed");
    }

    @Test
    public void DragAndDrop(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //how to create actions object / passing driver as a constructor
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droptarget"));

        //pause() --> waiting just like thread.sleep,accepsts miliseconds
        actions.pause(1000);

        //clicking accept cookies
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

        //we have to provide source and target to this method, it will drag and drop
        actions.dragAndDrop(source,target).perform();
    }

    @Test
    public void DragAndDropChaining(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //how to create actions object / passing driver as a constructor
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droptarget"));

        //pause() --> waiting just like thread.sleep,accepsts miliseconds
        actions.pause(1000);

        //clicking accept cookies
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

        //if you are chaining actions we add build() method before perform
        actions.moveToElement(source).clickAndHold().pause(2000).moveToElement(target).release().build().perform();

    }

}
