package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
       // driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/upload");

        driver.findElement(By.name("file")).sendKeys("/Users/o/Desktop/file.txt");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));

        Assert.assertEquals(uploadedFile.getText(),"file.txt","verify you got the uploaded file");
    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/upload");

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";

        String filePath = projectPath + "/" + relativePath;

        driver.findElement(By.name("file")).sendKeys(filePath);

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));

        Assert.assertEquals(uploadedFile.getText(),"testfile.txt","verify you got the uploaded file");
    }

}
