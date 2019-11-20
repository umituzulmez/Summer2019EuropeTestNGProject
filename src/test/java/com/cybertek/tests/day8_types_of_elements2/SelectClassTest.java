package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate the dropdown element with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //Create Select object by passing the element as a constructor
        Select stateList = new Select(dropdownElement);

        //getOptions() --> retruns all the available options from the dropdown list
        List<WebElement> options = stateList.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    @Test
    public void test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate the dropdown element with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //Create Select object by passing the element as a constructor
        Select stateList = new Select(dropdownElement);

        //verify that first option is "Select a State"
        String expectedOption = "Select a State";
        String actualOption = stateList.getFirstSelectedOption().getText();
        System.out.println(actualOption);
        Assert.assertEquals(expectedOption,actualOption, "verify first option is \"Select a State\"");

        //HOW TO SELECT OPTİIONS FROM THE DROPDOWN
        //1.USING VISIBLE TEXT
        //selectByVisibleText("Texas") --> selecting based on visible text
        stateList.selectByVisibleText("Texas");
        actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Texas");

        //2.USING INDEX NUMBER
        stateList.selectByIndex(51);
        System.out.println(stateList.getFirstSelectedOption().getText());
        actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Wyoming");

        //3.USING VALUE
        stateList.selectByValue("VA");
        System.out.println(stateList.getFirstSelectedOption().getText());
        actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Virginia");

    }
}
