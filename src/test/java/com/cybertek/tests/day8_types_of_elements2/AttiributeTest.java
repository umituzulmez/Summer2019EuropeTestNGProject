package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttiributeTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButton = driver.findElement(By.id("blue"));

        System.out.println(radioButton.getAttribute("value"));

        //get the value of name attribute
        System.out.println(radioButton.getAttribute("name"));
        //get the value of id attribute
        System.out.println(radioButton.getAttribute("id"));
        //get the value of type attribute
        System.out.println(radioButton.getAttribute("type"));
        //trying to get attribute does not exist
        System.out.println(radioButton.getAttribute("href"));
        //attribute without value (checked)
        System.out.println(radioButton.getAttribute("checked"));
        //"outherHTML" returns full html of that element
        System.out.println(radioButton.getAttribute("outerHTML"));



    }
}
