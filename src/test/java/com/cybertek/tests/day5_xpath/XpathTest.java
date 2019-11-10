package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        //driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //WebElement homeLink = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));

       //WebElement button4 = driver.findElement(By.xpath("//button[@onclick='button4()']"));

      //  button4.click();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement signUpButton =  driver.findElement(By.xpath("//*[.='Sign Up']"));

        signUpButton.click();

        //homeLink.click();

        //driver.quit();
    }
}
