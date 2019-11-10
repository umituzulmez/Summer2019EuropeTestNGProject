package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;

public class AmazonTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));

        searchButton.click();

        WebElement resultElement = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

        String result = resultElement.getText();

        System.out.println(result);

        driver.quit();
    }
}
